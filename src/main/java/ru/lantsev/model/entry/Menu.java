package ru.lantsev.model.entry;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Menu {
    @Id
    @Column(name = "id")
    private long id ;

    @ManyToMany
    @JoinTable(name = "menu_recipe" ,
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Recipe> recipes = new HashSet<>() ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe) ;
    }

    public void removeRecipe(Recipe recipe) {
        this.recipes.remove(recipe) ;
    }
}
