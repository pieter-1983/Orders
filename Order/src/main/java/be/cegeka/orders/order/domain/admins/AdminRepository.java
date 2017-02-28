package be.cegeka.orders.order.domain.admins;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
public class AdminRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Admin> getAllAdmins(){
        return entityManager.createQuery("select a from Admin a" , Admin.class).getResultList();
    }


    public void addAdmin(Admin admin) {
        entityManager.persist(admin);
    }

}