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

    @Column(name = "ORDER_DATE")

    private LocalDate orderDate;
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;
    @OneToMany
    @Column(name = "ITEM_QUANTITY_COMBO")
    private List<ItemQuantityCombo> itemQuantityCombos;

    public Order() {
        this.orderDate = LocalDate.now();
        itemQuantityCombos = new ArrayList<>();
    }


    public double getTotalPrice() {
        return totalPrice;
    }


    private double calculateTotalPrice(Order order){
        double totalPrice = 0;

        for (ItemQuantityCombo itemQuantityCombo : itemQuantityCombos)
        {
            totalPrice += itemQuantityCombo.getPrice();
        }

        return totalPrice;
    }


    public int getOrder_id() {
        return order_id;
    }
}
//future stories -- amount spent per customer
