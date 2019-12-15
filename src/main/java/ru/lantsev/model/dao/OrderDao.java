package ru.lantsev.model.dao;

import ru.lantsev.model.entry.Order;

import java.util.List;

public interface OrderDao {
    List<Order> allOrder();
    void add(Order order);
    void delete(Order order);
    void edit(Order order);
    Order getById(long id);
}
