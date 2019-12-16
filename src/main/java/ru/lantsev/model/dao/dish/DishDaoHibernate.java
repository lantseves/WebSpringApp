package ru.lantsev.model.dao.dish;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lantsev.model.entry.Dish;
import ru.lantsev.model.entry.Order;

import java.util.List;

@Transactional
@Repository
public class DishDaoHibernate implements DishDao {

    private SessionFactory sessionFactory ;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Dish> allDish() {
        return sessionFactory.getCurrentSession().createQuery( "from Dish", Dish.class).list();
    }

    @Override
    public List<Dish> allDishWithRecipe() {
        return sessionFactory.getCurrentSession().createQuery("select distinct d from Dish d " +
                "left join fetch d.recipe r", Dish.class ).list();
    }

    @Override
    public Dish save(Dish dish) {
        sessionFactory.getCurrentSession().saveOrUpdate(dish);
        return dish ;
    }

    @Override
    public void delete(Dish dish) {
        sessionFactory.getCurrentSession().delete(dish);
    }

    @Override
    public Dish getById(long id) {
        return sessionFactory.getCurrentSession().createQuery("select distinct d from Dish  d " +
                "left join fetch d.recipe r " +
                "where d.id = :id" , Dish.class)
                .setParameter("id" , id)
                .uniqueResult();
    }
}
