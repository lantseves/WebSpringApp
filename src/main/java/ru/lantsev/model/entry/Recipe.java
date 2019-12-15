package ru.lantsev.model.entry;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @Column(name = "id")
    private long id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "description")
    private String description ;

    @Column(name = "salary")
    private double salary ;

    @ManyToMany
    @JoinTable(name = "menu_recipe" ,
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")) 
    private Set<Recipe> recipes = new HashSet<>() ;

    @Version
    @Column(name = "version")
    private int version ;
}
