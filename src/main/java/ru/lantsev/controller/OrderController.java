package ru.lantsev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.lantsev.model.entry.Order;
import ru.lantsev.service.order.OrderService;

@RequestMapping("/")
@Controller
public class OrderController {

    private OrderService orderService ;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public String homePage(Model model) {
        return "homePage";
    }

    /*
    @GetMapping()
    public ModelAndView allOrder() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders/order");
        modelAndView.addObject("orders" , orderService.allOrder()) ;
        return modelAndView;
    }*/

    @GetMapping(value = "edit/{id}")
    public ModelAndView editOrder(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders/editOrder");
        modelAndView.addObject("order", orderService.getById(id)) ;
        return modelAndView;
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
