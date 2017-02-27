package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "STOCK_ENTRY_DATA")
public class StockEntryData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ENTRY_DATA_ID")
    private int stockEntryDataID;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    @Column(name = "QUANTITY")
    private int quantity;

    public StockEntryData() {
    }

    public StockEntryData(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}