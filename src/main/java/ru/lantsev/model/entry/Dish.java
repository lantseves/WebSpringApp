package ru.lantsev.model.entry;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dishes", schema = "springtest")
public class Dish {
    @Id
    @Column(name = "id")
    private long id ;

    @Column(name = "salary")
    private double salary ;

    @Column(name = "name")
    private String name ;

    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe ;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order ;

    @Version
    @Column(name = "version")
    private int version ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
