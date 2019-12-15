package ru.lantsev.service;

import ru.lantsev.model.entry.Order;

import java.util.List;

public interface OrderService {
    List<Order> allOrder();
    void add(Order order);
    void delete(Order order);
    void edit(Order order);
    Order getById(long id);
}
