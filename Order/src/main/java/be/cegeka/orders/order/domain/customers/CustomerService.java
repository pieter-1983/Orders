package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by stevene on 24/02/2017.
 */
public class CustomerService {
    @Inject
    private  CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.getAll();
    }
}
