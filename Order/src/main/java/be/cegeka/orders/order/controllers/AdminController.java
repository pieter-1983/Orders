package be.cegeka.orders.order.controllers;

import be.cegeka.orders.order.domain.admins.Admin;
import be.cegeka.orders.order.domain.admins.AdminService;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.item.ItemService;
import be.cegeka.orders.order.domain.stock.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Controller
public class AdminController {

    @Inject
    private AdminService adminService;
    @Inject
    private CustomerService customerService;
    @Inject
    private StockService stockService;

    @RequestMapping(value = "admin/item", method = RequestMethod.POST)
    public
    @ResponseBody
    void addItem(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "price", required = true) double sellPrice) {
        adminService.addItem(name, description, sellPrice);
    }

    @RequestMapping(value = "admin", method = RequestMethod.POST)
    @ResponseBody
    public void createAdmin(
            @RequestParam(value = "name", required = true) String name) throws Exception {
        adminService.createNewAdmin(name);
    }

    @RequestMapping(value = "admin/customer", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    @ResponseBody
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @RequestMapping(value = "admin/stock", method = RequestMethod.POST)
    @ResponseBody
    public void createStockEntryData(
            @RequestParam(value = "item_id", required = true) int item_id,
            @RequestParam(value = "quantity", required = true) int quantity) throws Exception {
        adminService.createStockEntryData(item_id, quantity);
    }
}