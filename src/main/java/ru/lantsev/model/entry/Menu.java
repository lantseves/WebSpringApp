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
}
