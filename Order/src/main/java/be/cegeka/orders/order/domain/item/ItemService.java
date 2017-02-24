package be.cegeka.orders.order.domain.item;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by dieterp on 24/02/2017.
 */
@Named
public class ItemService {
    @Inject
    private ItemRepository itemRepository;

    public void addItem(String name, String description , double sellPrice){

        Item item = new Item(name , description , sellPrice);

        itemRepository.addItem(item);
    }

}
