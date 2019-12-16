package ru.lantsev.service.recipe;

import ru.lantsev.model.entry.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> allRecipe();
    List<Recipe> allRecipeWithMenu() ;
    Recipe save(Recipe recipe);
    void delete(Recipe recipe);
    Recipe getById(long id);
}
