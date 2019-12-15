package ru.lantsev.model.entry;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private long salary ;

    @Version
    @Column(name = "version")
    private int version ;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Dish> dishes = new HashSet<>() ;

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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish) ;
    }

    public void remove(Dish dish) {
        this.dishes.remove(dish) ;
    }
}
