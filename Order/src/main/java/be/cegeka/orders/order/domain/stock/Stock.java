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

    @OneToMany
    @Column(name = "STOCK_ENTRY_DATA")
    private List<StockEntryData> stockOverview;

    public Stock() {
        stockOverview = new ArrayList<>();
    }
    public void addEntryDataToStock(StockEntryData entryData){
        stockOverview.add(entryData);
    }



    //
//    @Column (name = "STOCK")
//    List<ItemQuantityCombo> stock = new ArrayList<>();

}
