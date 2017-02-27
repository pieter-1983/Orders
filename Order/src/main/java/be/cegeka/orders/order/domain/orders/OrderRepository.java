package be.cegeka.orders.order.domain.orders;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getAllOrders(){
        return entityManager.createQuery("select o from Order o" , Order.class).getResultList();
    }

    @Transactional
    public void addOrder(Order order) {
        entityManager.persist(order);
    }
}