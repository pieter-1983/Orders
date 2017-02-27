package be.cegeka.orders.order.domain.item;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ItemService {
    @Inject
    private ItemRepository itemRepository;

    public void addItem(String name, String description, double sellPrice) {
        Item item = new Item(name, description, sellPrice);
        itemRepository.addItem(item);
    }

    public Item findItemByName(String name) throws Exception {
        for (Item item : itemRepository.getAllItems()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new Exception("there is no item found");
    }

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public Item findItemByID(int item_id) throws Exception {
        for (Item item : itemRepository.getAllItems()) {
            if (item.getId()==item_id) {
                return item;
            }
        }
        throw new Exception("there is no item found");
    }
}