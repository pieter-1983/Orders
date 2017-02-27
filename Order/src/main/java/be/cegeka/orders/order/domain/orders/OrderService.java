package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
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

    @Inject
    private CustomerService customerService;

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public Order createOrderEntry(int customer_id, int item_id, int quantity) throws Exception {
        Order shoppingCart = new Order();
        Customer customer = customerService.findCustomerByID(customer_id);
        customer.addOrdertoOrderList(shoppingCart);
        
        Item item = getRequestedItem(item_id);
        OrderEntryData inputOrderEntry = new OrderEntryData(item, quantity);
        shoppingCart.getContent().add(inputOrderEntry);

        return shoppingCart;
    }

    public Order createOrderEntry(int customer_id, int item_id, int quantity, int order_id) throws Exception {
        Order shoppingCart = getRequestedOrder(order_id);

        Item item = getRequestedItem(item_id);
        OrderEntryData inputOrderEntry = new OrderEntryData(item, quantity);
        shoppingCart.getContent().add(inputOrderEntry);

        return shoppingCart;
    }

    private Order getRequestedOrder(int order_id) throws Exception {
        for (Order order : orderRepository.getAllOrders()) {
            if (order.getOrder_id() == order_id) {
                return order;
            }
        }
        throw new Exception("invalid order_id");
    }

    private Item getRequestedItem(int item_id) throws Exception {
        for (Item item : itemRepository.getAllItems()) {
            if (item.getId() == item_id) {
                return item;
            }
        }
        throw  new Exception("does not exist");
    }
}