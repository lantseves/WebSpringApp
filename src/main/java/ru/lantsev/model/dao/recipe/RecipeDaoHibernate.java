package ru.lantsev.model.dao.recipe;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lantsev.model.entry.Recipe;

import java.util.List;

@Transactional
@Repository
public class RecipeDaoHibernate implements RecipeDao {

    private SessionFactory sessionFactory ;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recipe> allRecipe() {
        return sessionFactory.getCurrentSession().createQuery("from Recipe ", Recipe.class).list();
    }

    @Override
    public Recipe save(Recipe recipe) {
        sessionFactory.getCurrentSession().saveOrUpdate(recipe);
        return recipe;
    }

    @Override
    public void delete(Recipe recipe) {
        sessionFactory.getCurrentSession().delete(recipe);
    }

    @Override
    public Recipe getById(long id) {
        return sessionFactory.getCurrentSession().createQuery("select distinct r from Recipe r " +
                "where r.id = :id" , Recipe.class)
                .setParameter("id" , id)
                .uniqueResult();
    }
}
