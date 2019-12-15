package ru.lantsev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lantsev.model.dao.order.OrderDao;
import ru.lantsev.model.entry.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao ;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> allOrder() {
        return orderDao.allOrder();
    }

    public void add(Order order) {
        orderDao.add(order);
    }

    public void delete(Order order) {
        orderDao.delete(order);
    }

    public void edit(Order order) {
        orderDao.edit(order);
    }

    public Order getById(long id) {
        return orderDao.getById(id);
    }
}
