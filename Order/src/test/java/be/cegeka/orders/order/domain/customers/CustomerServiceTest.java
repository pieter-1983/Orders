package be.cegeka.orders.order.domain.customers;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.awt.print.Book;
import java.util.Arrays;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;


    @Test
    public void getAllCustomers() throws Exception {
        Customer testcust=new Customer("woef","waf", "Koekoekstraat 70", "woefwaf@gmail.com", "0497123446");
        Customer testcust1=new Customer("wof","waaf", "Koekoekstraat 10", "wof_waaf@hotmail.com", "0499123445");
        when( customerService.getAllCustomers()).thenReturn(Arrays.asList(testcust1,testcust));
        Assertions.assertThat(customerRepository.getAll()).containsOnly(testcust1,testcust);

    }
    @Test
    public void addCustomer() throws Exception {
        customerService.addCustomer("woef","waf", "Koekoekstraat 70", "woefwaf@gmail.com", "0497123446");
        Mockito.verify(customerRepository).addCustomer(Mockito.refEq(new Customer("woef","waf", "Koekoekstraat 70", "woefwaf@gmail.com", "0497123446"),"id"));
    }
}