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
    private Set<Menu> menus = new HashSet<>() ;

    @Version
    @Column(name = "version")
    private int version ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
