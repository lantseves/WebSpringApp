package ru.lantsev.model.dao.order;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lantsev.model.dao.order.OrderDao;
import ru.lantsev.model.entry.Order;

import java.util.List;

@Transactional
@Repository
public class OrderDaoHibernate implements OrderDao {
    SessionFactory sessionFactory ;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> allOrder() {
        List<Order> list = sessionFactory.getCurrentSession().createQuery("from Order").list() ;
        return list;
    }

    @Override
    public void add(Order order) {
        sessionFactory.getCurrentSession().persist(order);
    }

    @Override
    public void delete(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public void edit(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public Order getById(long id) {
        return sessionFactory.getCurrentSession().get(Order.class , id);
    }
}
