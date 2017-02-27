package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.item.Item;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by pieterst on 27/02/2017.
 */
@Named
public class StockService {
    @Inject
    private Stock stock;

    public void addStockEntryData(Item item, int quantity) {
        StockEntryData stockEntryData= new StockEntryData(item, quantity);
        stock.addEntryDataToStock(stockEntryData);
    }
}
