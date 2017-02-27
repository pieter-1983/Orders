package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.domain.orders.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int customer_id;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private List<Order> orderList;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column (name = "E_MAIL")
    private String eMail;
    @Column (name = "ADDRESS")
    private String address;
    @Column (name = "PHONE_NUMBER")
    private String phoneNumber;

    private Customer() {
    }

    public Customer(String firstName, String lastName, String address, String eMail, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return customer_id;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrdertoOrderList(Order order) {
        orderList.add(order);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}