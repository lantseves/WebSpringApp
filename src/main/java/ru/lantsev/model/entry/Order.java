package ru.lantsev.model.entry;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders" , schema = "springtest")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id ;
    @Column(name = "name")
    private String name ;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_ordered")
    private Date dateOrdered ;

    @Column(name = "status_order")
    private StatusOrder statusOrder ;

    @Column(name = "salary")
    private double salary ;

    @Version
    @Column(name = "version")
    private int version ;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Dish> dishes = new ArrayList<>() ;

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

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish) ;
    }

    public void remove(Dish dish) {
        this.dishes.remove(dish) ;
    }
}
