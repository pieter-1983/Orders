package be.cegeka.orders.order.domain.stock;
import be.cegeka.orders.order.domain.orders.ItemQuantityCombo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dieterp on 23/02/2017.
 */
@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name =  "STOCK_ID")
    private int stockId;

    @Column(name =  "ITEM_ID")
    private int itemId;

    @Column(name =  "QUANTITY")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    //
//    @Column (name = "STOCK")
//    List<ItemQuantityCombo> stock = new ArrayList<>();

}
