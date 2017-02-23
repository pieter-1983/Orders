package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE_QUANTITY_COMBO")
public class ArticleQuantityCombo {

    @Column (name = "ITEM_ID")
    private Item item;
    @Column (name= "QUANTITY")
    private int quantity;

    public ArticleQuantityCombo(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }


}
