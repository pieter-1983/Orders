package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import org.apache.poi.ss.formula.PlainCellCache;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
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
    private Map<Item, Integer> colliPerOrder;

    public Order(Customer customer) {
        this.customer = customer;
        this.orderDate = LocalDate.now();
        colliPerOrder = new HashMap<>();
    }

    public Order(){}

    public int getOrder_id() {
        return order_id;
    }
}
//future stories -- amount spent per customer
