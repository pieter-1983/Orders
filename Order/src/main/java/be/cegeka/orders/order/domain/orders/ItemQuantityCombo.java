package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_QUANTITY_COMBO")
public class ItemQuantityCombo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_QUANTITY_ID")
    private int ITEM_QUANTITY_id;
    @ManyToOne
    @Column (name = "ITEM_ID")
    private Item item;
    @Column (name= "QUANTITY")
    private int quantity;

    public ItemQuantityCombo(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getPrice() {
        return item.getSellingPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
