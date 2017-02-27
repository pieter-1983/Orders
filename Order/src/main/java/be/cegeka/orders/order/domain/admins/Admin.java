package be.cegeka.orders.order.domain.admins;

import javax.persistence.*;

@Entity
@Table(name = "ADMINS")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADMIN_ID")
    private int admin_id;

    @Column (name = "NAME")
    private String adminName;

    public Admin() {
    }

    public Admin(String adminName) {
        this.adminName = adminName;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public String getUserName() {
        return adminName;
    }
}