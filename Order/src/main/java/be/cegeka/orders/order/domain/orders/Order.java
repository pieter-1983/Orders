package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int order_id;

    @OneToMany (cascade = CascadeType.ALL)
    @Column(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;
    private List<ItemQuantityCombo> colliPerOrder;

    public Order(Customer customer) {
        this.customer = customer;
        this.orderDate = LocalDate.now();
        colliPerOrder = new ArrayList<>();
    }

    public Order(){}

    public int getOrder_id() {
        return order_id;
    }
}
//future stories -- amount spent per customer
