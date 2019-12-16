package ru.lantsev.service.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lantsev.model.dao.dish.DishDao;
import ru.lantsev.model.entry.Dish;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private DishDao dishDao ;

    @Autowired
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Override
    public List<Dish> allDish() {
        return dishDao.allDish();
    }

    @Override
    public List<Dish> allDishWithRecipe() {
        return dishDao.allDishWithRecipe();
    }

    @Override
    public Dish save(Dish dish) {
        return dishDao.save(dish);
    }

    @Override
    public void delete(Dish dish) {
        dishDao.delete(dish);
    }

    @Override
    public Dish getById(long id) {
        return dishDao.getById(id);
    }
}
