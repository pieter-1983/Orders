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
    @Column(name = "DELIVERY_DATE")
    private LocalDate deliverydate;

    public Order() {
        this.orderDate = LocalDate.now();
        itemQuantityCombos = new ArrayList<>();
        this.deliverydate=LocalDate.now().plusDays(7);
    }


    public double getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }

    public void addItemQuantityCombo(ItemQuantityCombo combo){
        itemQuantityCombos.add(combo);
    }

    private void calculateTotalPrice(){
        this.totalPrice = 0;
        for (ItemQuantityCombo itemQuantityCombo : itemQuantityCombos)
        {
            totalPrice += itemQuantityCombo.getPrice();
        }
    }


    public int getOrder_id() {
        return order_id;
    }
}
//future stories -- amount spent per customer
