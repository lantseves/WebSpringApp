package ru.lantsev.model.dao.menu;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lantsev.model.entry.Menu;

import java.util.List;

@Transactional
@Repository
public class MenuDaoHibernate implements MenuDao {

    private SessionFactory sessionFactory ;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Menu> allMenu() {
        return sessionFactory.getCurrentSession().createQuery("from Menu m" , Menu.class).list();
    }

    @Override
    public List<Menu> allMenuWithRecipe() {
        return sessionFactory.getCurrentSession().createQuery("select distinct m from Menu m " +
                "left join fetch m.recipes r" , Menu.class).list();
    }

    @Override
    public Menu save(Menu menu) {
        sessionFactory.getCurrentSession().saveOrUpdate(menu);
        return menu;
    }

    @Override
    public void delete(Menu menu) {
        sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    public Menu getById(long id) {
        return sessionFactory.getCurrentSession().createQuery("select distinct m from Menu m " +
                "left join fetch m.recipes r", Menu.class).uniqueResult();
    }
}
