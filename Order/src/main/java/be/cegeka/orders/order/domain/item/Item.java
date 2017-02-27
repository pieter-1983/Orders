package be.cegeka.orders.order.domain.item;

import be.cegeka.orders.order.domain.stock.Stock;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")

    private String description;

    @Column(name = "SELLING_PRICE")
    private double sellingPrice;

    public Item(String name, String description, double sellingPrice) {
        this.name = name;
        this.description = description;
        this.sellingPrice = sellingPrice;
    }

    public Item() {
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.sellingPrice, sellingPrice) != 0) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        return description != null ? description.equals(item.description) : item.description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(sellingPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}