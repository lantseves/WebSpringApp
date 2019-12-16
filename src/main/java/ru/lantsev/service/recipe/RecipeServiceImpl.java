package ru.lantsev.service.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lantsev.model.dao.dish.DishDao;
import ru.lantsev.model.dao.recipe.RecipeDao;
import ru.lantsev.model.entry.Recipe;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeDao {

    private RecipeDao recipeDao ;

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @Override
    public List<Recipe> allRecipe() {
        return recipeDao.allRecipe();
    }

    @Override
    public List<Recipe> allRecipeWithMenu() {
        return recipeDao.allRecipeWithMenu();
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeDao.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeDao.delete(recipe);
    }

    @Override
    public Recipe getById(long id) {
        return recipeDao.getById(id);
    }
}
