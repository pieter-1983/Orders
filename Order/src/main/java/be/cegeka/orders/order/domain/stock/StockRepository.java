package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.item.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by dieterp on 23/02/2017.
 */
public class StockRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Stock> getAll(){
        return entityManager.createQuery("select c from Stock c" , Stock.class).getResultList();
    }
}
