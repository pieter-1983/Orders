package be.cegeka.orders.order.domain.orders;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class OrderService {

    @Inject
    private OrderRepository orderRepository;
    
    public void addOrder (Order order){
        orderRepository.addOrder(order);
    }
}