package be.cegeka.orders.order.controllers;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /// RESPONSIBILITY OF ADMIN!!
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public List<Customer> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addCustomer(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "eMail") String eMail,
            @RequestParam(value = "phoneNumber") String phoneNumber){
        customerService.addCustomer(firstName, lastName, address, eMail, phoneNumber);
    }
}
