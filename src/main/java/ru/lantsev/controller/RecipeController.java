package ru.lantsev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.lantsev.model.entry.Recipe;
import ru.lantsev.service.recipe.RecipeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@RequestMapping("/recipes")
@Controller
public class RecipeController {
    private RecipeService recipeService ;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String recipes(Model model) {
        List<Recipe> list = recipeService.allRecipe() ;
        model.addAttribute("recipes", list) ;
        return "recipesPage";
    }

    @GetMapping(value = "/{id}", params = "form")
    public String editRecipe(@PathVariable("id") long id, Model model) {
        model.addAttribute("recipe", recipeService.getById(id)) ;
        return "recipeEditPage";
    }

    @PostMapping(value = "/{id}", params = "form")
    public String editOrder(@Validated Recipe recipe, @PathVariable("id") long id,
                            BindingResult bindingResult,
                            Model model,
                            HttpServletRequest httpServletRequest,
                            RedirectAttributes redirectAttributes,
                            Locale locale) {
        if (bindingResult.hasErrors()) {
            return "redirect:/recipes/" + id + "?form" ;
        }

        Recipe recipeResult = recipeService.getById(recipe.getId()) ;
        recipeResult.setName(recipe.getName());
        recipeResult.setDescription(recipe.getDescription());
        recipeResult.setSalary(recipe.getSalary());
        recipeService.save(recipeResult);
        return "redirect:/recipes" ;
    }

    @GetMapping(params = "form")
    public String addOrder() {
        return "recipeAddPage" ;
    }

    @PostMapping(params = "form")
    public String addOrder(@Validated Recipe recipe) {
        recipeService.save(recipe);
        return "redirect:/recipes" ;
    }

    @GetMapping(value="delete/{id}")
    public ModelAndView deleteOrder(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/recipes");
        Recipe recipe = recipeService.getById(id);
        recipeService.delete(recipe);
        return modelAndView;
    }

}
