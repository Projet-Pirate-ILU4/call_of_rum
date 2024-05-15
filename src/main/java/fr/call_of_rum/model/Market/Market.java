package fr.call_of_rum.model.Market;

import fr.call_of_rum.model.item.UseableItem;

import java.util.List;
import java.util.Random;

public class Market {

    private final List<UseableItem> items;
    private final int numberItems = 4;

    public Market(List<UseableItem> items) {
        this.items = items;
    }

    public UseableItem[] getItemsForSale() {
        UseableItem[] itemSells = new UseableItem[4];
        Random random = new Random();
        int randomNumber ;
        for (int i = 0; i < numberItems; i++) {
            if (!items.isEmpty()) {
                randomNumber = random.nextInt(items.size() + 1);
                itemSells[i] = items.get(randomNumber);
            } else {
                itemSells[i] = null;
            }
        }
        return itemSells;
    }


    public void removeItemFromMarket(UseableItem item) {
        items.remove(item);
    }
}
