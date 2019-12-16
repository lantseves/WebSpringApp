package ru.lantsev.service.order;

import ru.lantsev.model.entry.Order;

import java.util.List;

public interface OrderService {
    List<Order> allOrder();
    List<Order> allOrderWithDish() ;
    Order save(Order order);
    void delete(Order order);
    Order getById(long id);
}
