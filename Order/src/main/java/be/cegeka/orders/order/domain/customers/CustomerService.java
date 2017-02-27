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
    public void addCustomer(String firstName, String lastName, String address, String eMail, String phoneNumber) {
        Customer customer = new Customer(firstName,lastName, address, eMail, phoneNumber);
        customerRepository.addCustomer(customer);
    }

    public Customer findCustomerByID(int id) throws Exception {
        for (Customer customer : getAllCustomers()) {
            if (IDsMatch(id, customer)) {
                return customer;
            }
        }
        throw new Exception("customer not found");
    }

    private boolean IDsMatch(int id, Customer customer) {
        return customer.getId() == id;
    }
}
