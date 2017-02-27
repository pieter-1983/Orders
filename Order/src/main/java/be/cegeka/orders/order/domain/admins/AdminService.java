package be.cegeka.orders.order.domain.admins;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerRepository;
import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.item.ItemRepository;
import be.cegeka.orders.order.domain.item.ItemService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by pieterst on 27/02/2017.
 */
@Named
public class AdminService {

    @Inject
    private AdminRepository adminRepository;

    @Inject
    private ItemService itemService;

    @Inject
    private CustomerService customerService;

    public void addItem(String name, String description, double sellingPrice) {
        itemService.addItem(name, description, sellingPrice);
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void createNewAdmin(String name) {
        Admin newAdmin= new Admin(name);
        adminRepository.addAdmin(newAdmin);
    }



}
