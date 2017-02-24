package be.cegeka.orders.order.domain.item;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by dieterp on 23/02/2017.
 */
@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SELLING_PRICE")
    private double sellingPrice;

    public Item(String name, String description, double sellingPrice) {
        this.name = name;
        this.description = description;
        this.sellingPrice = sellingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
}
