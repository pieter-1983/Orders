package be.cegeka.orders.order.domain.stock;
import javax.inject.Named;
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

    @Column (name = "STOCK")
    List<ItemQuantityCombo> stock = new ArrayList();

}
