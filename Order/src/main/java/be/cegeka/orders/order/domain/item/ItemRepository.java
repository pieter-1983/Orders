package be.cegeka.orders.order.domain.item;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by dieterp on 23/02/2017.
 */
public class ItemRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Item> getAll(){
        return entityManager.createQuery("select c from Item c" , Item.class).getResultList();
    }

    public void addItem(Item item) {
        entityManager.createQuery("");
    }
}
