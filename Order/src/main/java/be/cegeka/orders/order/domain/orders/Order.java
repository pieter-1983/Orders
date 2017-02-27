package be.cegeka.orders.order.domain.orders;

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
    private List<OrderEntryData> shoppingCart;
    @Column(name = "DELIVERY_DATE")
    private LocalDate shippingDate;


    public Order() {
        this.orderDate = LocalDate.now();
        shoppingCart = new ArrayList<>();
        // shipping date
        this.shippingDate = LocalDate.now().plusDays(1);
    }

    public double getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }

    public void addItemQuantityCombo(OrderEntryData combo){
        shoppingCart.add(combo);
    }

    private void calculateTotalPrice(){
        this.totalPrice = 0;
        for (OrderEntryData orderEntryData : shoppingCart)
        {
            totalPrice += orderEntryData.getPrice();
        }
    }


    public int getOrder_id() {
        return order_id;
    }

    public List<OrderEntryData> getShoppingCart() {
        return shoppingCart;
    }

}
//future stories -- amount spent per customer
