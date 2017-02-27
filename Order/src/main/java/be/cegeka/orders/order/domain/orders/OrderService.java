package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.item.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private ItemRepository itemRepository;

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public Order createOrderEntry(Item input, int quantity) {
        Order tempOrder = new Order();

        // loopt over lege lijst ...
        //for (Item input : inputs) {
        if (checkIfItemExists(input)) {
            ItemQuantityCombo inputOrderEntry = new ItemQuantityCombo(input, quantity);
            tempOrder.getShoppingCart().add(inputOrderEntry);
        }
        return tempOrder;
    }
////        }
////        return tempOrder;
//    }

    public boolean checkIfItemExists(Item input) {

        for (Item item : itemRepository.getAllItems()) {
            if (item.getName().equals(input.getName())) {
                return true;
            }
        }
        return false;
    }
}