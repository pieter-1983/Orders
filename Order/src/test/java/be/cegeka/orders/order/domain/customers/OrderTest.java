package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.orders.ItemQuantityCombo;
import be.cegeka.orders.order.domain.orders.Order;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class OrderTest {

    @Test
    public void calculateTotalPrice_ShouldReturnTotalPrice() throws Exception{

        Order order = new Order();
        Item cola = new Item("Cola","Grote fles",10);
        Item fanta = new Item("Fanta","kleine fles",2);

        ItemQuantityCombo deColaCombo = new ItemQuantityCombo(cola, 5);
        ItemQuantityCombo deFantaCombo = new ItemQuantityCombo(fanta, 7);

        order.addItemQuantityCombo(deColaCombo);
        order.addItemQuantityCombo(deFantaCombo);

        Assertions.assertThat(order.getTotalPrice()).isEqualTo(64);

    }
}
