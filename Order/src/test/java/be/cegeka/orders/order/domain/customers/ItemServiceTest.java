package be.cegeka.orders.order.domain.customers;
import be.cegeka.orders.order.domain.item.Item;
import be.cegeka.orders.order.domain.item.ItemRepository;
import be.cegeka.orders.order.domain.item.ItemService;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.*;

public class ItemServiceTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository mockedItemRepository;

    @Test
    public void AddItemToRepository_IsInRepository() throws Exception
    {
        Item item = new Item("Cola", "Grote Fles", 10);
        itemService.addItem("Cola", "Grote Fles", 10);
        verify(mockedItemRepository).addItem(refEq(item, "id"));
    }
}