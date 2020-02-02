package ru.lantsev.model.dao.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.lantsev.model.entry.Order;

import java.util.List;

public interface OrderDao {
    List<Order> allOrder();
    List<Order> allOrderWithDish() ;
    Order save(Order order);
    void delete(Order order);
    Order getById(long id);
}
