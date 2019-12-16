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


    @Transactional(readOnly = true)
    @Override
    public List<Order> allOrder() {
        return sessionFactory.getCurrentSession().createQuery("from Order" , Order.class).list();
    }

    @Override
    public List<Order> allOrderWithDish() {
        return sessionFactory.getCurrentSession().createQuery(
                "select o from Order o " +
                "left join fetch o.dishes d " +
                        "left join fetch d.recipe r" , Order.class)
                .list();
    }

    @Override
    public Order save(Order order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
        return order ;
    }

    @Override
    public void delete(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Transactional(readOnly = true)
    @Override
    public Order getById(long id) {
        return sessionFactory.getCurrentSession().createQuery(
                "select o from Order o " +
                "left join fetch o.dishes where o.id = :id" , Order.class)
                .setParameter("id" , id)
                .uniqueResult();
    }
}
