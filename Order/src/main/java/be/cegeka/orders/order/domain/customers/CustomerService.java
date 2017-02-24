package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by stevene on 24/02/2017.
 */
@Named
public class CustomerService {
    @Inject
    private  CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.getAll();
    }
@Transactional
    public void addCustomer(String name, String lastName) {
        Customer customer=new Customer(name,lastName);
        customerRepository.addCustomer(customer);
    }
}
