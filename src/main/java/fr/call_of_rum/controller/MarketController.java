package fr.call_of_rum.controller;

import fr.call_of_rum.model.Market.Market;
import fr.call_of_rum.model.item.UseableItem;
import fr.call_of_rum.model.pirate.Inventory;
import fr.call_of_rum.model.pirate.Pirate;

import java.util.List;

public class MarketController {
    private Market market;

    public MarketController(Market market) {
        this.market = market;
    }

    public UseableItem[] getItemsForSale() {
        return market.getItemsForSale();
    }

    public void sellItem(List<UseableItem> items, Inventory inventory,Pirate pirate) {
        for (UseableItem item : items) {
            market.removeItemFromMarket(item);
            inventory.add(item);
            pirate.setCoins(pirate.getCoins() - item.getPrice());
        }
    }

}
