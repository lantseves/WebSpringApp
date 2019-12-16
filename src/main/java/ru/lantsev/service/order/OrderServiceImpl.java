package ru.lantsev.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lantsev.model.dao.order.OrderDao;
import ru.lantsev.model.entry.Order;
import ru.lantsev.service.order.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao ;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> allOrder() {
        return orderDao.allOrder();
    }

    @Override
    public List<Order> allOrderWithDish() {
        return orderDao.allOrderWithDish();
    }
    @Override
    public Order save(Order order) {
        return orderDao.save(order);
    }
    @Override
    public void delete(Order order) {
        orderDao.delete(order);
    }

    @Override
    public Order getById(long id) {
        return orderDao.getById(id);
    }
}
