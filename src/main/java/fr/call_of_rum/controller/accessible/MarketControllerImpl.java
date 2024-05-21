package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.model.market.ItemStock;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.util.ItemType;

public class MarketControllerImpl implements MarketController {
	
	private Market market;
	
	public MarketControllerImpl(Market market) {
		this.market = market;
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

}
