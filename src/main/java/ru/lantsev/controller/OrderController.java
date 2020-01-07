package ru.lantsev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.lantsev.model.entry.Order;
import ru.lantsev.service.order.OrderService;

@RequestMapping("/orders")
@Controller
public class OrderController {

    private OrderService orderService ;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String orders(Model model) {
        model.addAttribute("orders", orderService.allOrder()) ;
        return "ordersPage";
    }

    @GetMapping(value = "/{id}", params = "form")
    public String editOrder(@PathVariable("id") long id, Model model) {
        model.addAttribute("order", orderService.getById(id)) ;
        return "orderEditPage";
    }

    @PostMapping(value = "edit")
    public ModelAndView editOrder(@ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.setViewName("redirect:/");
        orderService.save(order);
        return modelAndView ;
    }

    @GetMapping(value = "add")
    public ModelAndView addOrder() {
        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.setViewName("orders/editOrder");
        return modelAndView ;
    }

    @PostMapping(value = "add")
    public ModelAndView addOrder(@ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.setViewName("redirect:/");
        orderService.save(order);
        return modelAndView ;
    }

    @GetMapping(value="delete/{id}")
    public ModelAndView deleteOrder(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Order order = orderService.getById(id);
        orderService.delete(order);
        return modelAndView;
    }
}
