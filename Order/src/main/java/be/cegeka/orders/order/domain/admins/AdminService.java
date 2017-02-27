package be.cegeka.orders.order.domain.admins;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerRepository;
import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.item.ItemRepository;
import be.cegeka.orders.order.domain.item.ItemService;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.stock.StockService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class AdminService {

    @Inject
    private AdminRepository adminRepository;
    @Inject
    private StockService stockService;
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
        Admin newAdmin = new Admin(name);
        adminRepository.addAdmin(newAdmin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    public List<Order> viewOrderOfCustomer(int id) throws Exception {
        Customer foundCustomer = customerService.findCustomerByID(id);
        return foundCustomer.getOrderList();
    }

    public void createStockEntryData(int item_id, int quantity) throws Exception {
        Item item=itemService.findItemByID(item_id);
        stockService.addStockEntryData(item, quantity);
    }
}