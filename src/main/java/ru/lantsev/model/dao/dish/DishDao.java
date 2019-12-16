package ru.lantsev.model.dao.dish;

import ru.lantsev.model.entry.Dish;
import ru.lantsev.model.entry.Order;

import java.util.List;


public interface DishDao {
    List<Dish> allDish();
    List<Dish> allDishWithRecipe() ;
    Dish save(Dish dish);
    void delete(Dish dish);
    Dish getById(long id);
}
