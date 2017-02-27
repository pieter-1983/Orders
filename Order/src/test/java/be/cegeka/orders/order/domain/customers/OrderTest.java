package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.orders.OrderEntryData;
import be.cegeka.orders.order.domain.orders.Order;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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

        OrderEntryData deColaCombo = new OrderEntryData(cola, 5);
        OrderEntryData deFantaCombo = new OrderEntryData(fanta, 7);

        order.addItemQuantityCombo(deColaCombo);
        order.addItemQuantityCombo(deFantaCombo);

        Assertions.assertThat(order.getTotalPrice()).isEqualTo(64);
    }
}