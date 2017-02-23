package be.cegeka.orders.order.domain.stock;

import javax.persistence.*;

/**
 * Created by dieterp on 23/02/2017.
 */
@Entity
@Table
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "STOCK_ID")
    private int stockId;

    @Column(name =  "ITEM_ID")
    private int itemId;




}
