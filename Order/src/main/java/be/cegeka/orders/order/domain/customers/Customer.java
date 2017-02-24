package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.domain.orders.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int customer_id;
    @OneToMany (cascade = CascadeType.ALL)
    @Column(name = "ORDER_ID")
    private List<Order> orderList;

    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;

    private Customer() {
    }

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return customer_id;
    }
}
