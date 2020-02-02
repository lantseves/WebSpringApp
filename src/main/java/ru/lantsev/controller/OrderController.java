package ru.lantsev.controller;

import javafx.scene.layout.BorderRepeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.lantsev.model.entry.Dish;
import ru.lantsev.model.entry.Order;
import ru.lantsev.model.entry.Recipe;
import ru.lantsev.model.entry.StatusOrder;
import ru.lantsev.service.order.OrderService;
import ru.lantsev.service.recipe.RecipeService;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RequestMapping("/orders")
@Controller
public class OrderController {

    private OrderService orderService ;
    private RecipeService recipeService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String orders(Model model) {
        model.addAttribute("orders", orderService.allOrder()) ;
        return "ordersPage";
    }

    @GetMapping(value = "/{id}", params = "form")
    public String editOrder(@PathVariable("id") long id, Model model) {
        Order order = orderService.getById(id) ;
        model.addAttribute("order", order ) ;
        model.addAttribute("statusOrder", StatusOrder.values()) ;
        return "orderEditPage";
    }

    @PostMapping(value = "/{id}", params = "form")
    public String editOrder(@Validated Order order,
                            @PathVariable("id") long id,
                            @RequestParam("statusOrder") String statusOrder,
                            BindingResult bindingResult,
                            Model model,
                            HttpServletRequest httpServletRequest,
                            RedirectAttributes redirectAttributes,
                            Locale locale) {
        if (bindingResult.hasErrors()) {
            return "redirect:/orders/" + id + "?form" ;
        }
        Order orderResult = orderService.getById(id) ;
        orderResult.setName(order.getName());
        orderResult.setSalary(order.getSalary());
        orderResult.setStatusOrder(StatusOrder.valueOf(statusOrder));
        orderService.save(orderResult);
       return "redirect:/orders" ;
    }

    @GetMapping(params = "form")
    public String addOrder(Model model) {
        model.addAttribute("recipes" , recipeService.allRecipe()) ;
        return "orderAddPage" ;
    }

    @PostMapping(params = "form")
    public String addOrder(@Validated Order order,
                           @RequestParam("quantity") List<Integer> quantities,
                           @RequestParam("recipe") List<Long> recipes,
                           Model model,
                           BindingResult bindingResult,
                           HttpServletRequest httpServletRequest,
                           RedirectAttributes redirectAttributes) {
        //TODO сделать автоматическую сборку в Order
        double orderSalary = 0 ;
        for (int i = 0 ; i < recipes.size() ; i++) {
            if(quantities.get(i) != 0) {
                Recipe tempRecipe = recipeService.getById(recipes.get(i));

                Dish tempDish = new Dish();
                tempDish.setName(tempRecipe.getName());
                tempDish.setQuantity(quantities.get(i));
                tempDish.setSalary(quantities.get(i) * tempRecipe.getSalary());
                orderSalary += quantities.get(i) * tempRecipe.getSalary();
                tempDish.setRecipe(tempRecipe);
                tempDish.setOrder(order);
                order.getDishes().add(tempDish);
            }
        }
        order.setSalary(orderSalary);
        order.setDateOrdered(new Date());
        order.setStatusOrder(StatusOrder.NEW);
        orderService.save(order);
        return "redirect:/orders" ;
    }

    @GetMapping(value="delete/{id}")
    public ModelAndView deleteOrder(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/orders");
        Order order = orderService.getById(id);
        orderService.delete(order);
        return modelAndView;
    }
}
