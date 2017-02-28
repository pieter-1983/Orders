package be.cegeka.orders.order.controllers;

import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.orders.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/customer")
@Transactional
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Inject
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addCustomer(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "eMail") String eMail,
            @RequestParam(value = "phoneNumber") String phoneNumber) {
        customerService.addCustomer(firstName, lastName, address, eMail, phoneNumber);
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    @ResponseBody
    public void addItemToOrder(
            @RequestParam(value = "customerID", required = true) int customer_id,
            @RequestParam(value = "item_id") int item_id,
            @RequestParam(value = "quantity") int quantity,
            @RequestParam(value = "order_id", required = false) Integer order_id) throws Exception {
        if (order_id==null) {
            orderService.createOrderEntry(customer_id, item_id, quantity);
        } else {
            orderService.createOrderEntry(customer_id, item_id, quantity, order_id);
        }
    }
}