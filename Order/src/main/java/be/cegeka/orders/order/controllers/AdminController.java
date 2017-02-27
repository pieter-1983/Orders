package be.cegeka.orders.order.controllers;

import be.cegeka.orders.order.domain.admins.AdminService;
import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.item.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.List;

/**
 * Created by dieterp on 24/02/2017.
 */

@Controller
public class AdminController {

    @Inject
    private AdminService adminService;

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Item> getItems(){
        return  adminService.getAllCustomers();
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public
    @ResponseBody
    void addItem(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "price", required = true) double sellPrice)
    {
        adminService.addItem(name,description,sellPrice);
    }


    @RequestMapping(value = "item/search", method = RequestMethod.GET)
    public
    @ResponseBody
    Item searchItemByName(
            @RequestParam(value = "name", required = true) String name) throws Exception {
        return adminService.findItemByName(name);
    }

}
