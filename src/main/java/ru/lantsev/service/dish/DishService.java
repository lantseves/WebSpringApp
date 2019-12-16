package ru.lantsev.service.dish;

import ru.lantsev.model.entry.Dish;

import java.util.List;

public interface DishService {
    List<Dish> allDish();
    List<Dish> allDishWithRecipe() ;
    Dish save(Dish dish);
    void delete(Dish dish);
    Dish getById(long id);
}
