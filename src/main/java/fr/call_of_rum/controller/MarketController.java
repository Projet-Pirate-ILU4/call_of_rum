package fr.call_of_rum.controller;

import fr.call_of_rum.controller.accessible.IMarketController;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.market.ItemStock;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.ItemType;

public class MarketController implements IMarketController {
	
	private PlayerController playerController;
	
	private Market market;
	
	public MarketController(Market market, PlayerController playerController) {
		this.market = market;
		this.playerController = playerController;
	}

	@Override
	public ItemType[] getItemForSale() {
		ItemType[] itemTypes = new ItemType[market.getNumberOfItems()];
		ItemStock[] itemStock = market.getItemsForSale();
		for (int i = 0; i<itemStock.length; i++) {
			itemTypes[i] = itemStock[i].getType();
		}
		return itemTypes;
	}

	@Override
	public int getPrice(int itemIndex) {
		return market.getPrice(itemIndex);
	}
	
	public void buy(Pirate pirate, int itemIndex) {
        int price = market.getPrice(itemIndex);
        
        int savings = pirate.getCoins();
        if (savings >= price) {
    		Item boughtItem = market.getItem(itemIndex);
    		playerController.takeItem(pirate, boughtItem);
        	pirate.setCoins(savings - price);
        }
	}

}
