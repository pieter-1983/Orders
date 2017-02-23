package be.cegeka.orders.order.domain.items;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by dieterp on 23/02/2017.
 */
@Entity
@Table(name = "ITEMS")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SELLING_PRICE")
    private BigDecimal sellingPrice;




}
