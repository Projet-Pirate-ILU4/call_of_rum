package fr.call_of_rum.controller;

import fr.call_of_rum.model.item.UseableItem;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Pirate;

public class BuyController {
	
	private TakeItemController takeItemController;
	
	private Market market;
	
	public BuyController(TakeItemController takeItemController, Market market) {
		this.takeItemController = takeItemController;
		this.market = market;
	}

	public void buy(Pirate pirate, int itemIndex) {
		UseableItem boughtItem = market.getItem(itemIndex);
		
        int price = boughtItem.getPrice();
        int savings = pirate.getCoins();
        if (savings >= price) {
        	takeItemController.takeItem(pirate, boughtItem);
        	pirate.setCoins(savings - price);
        }
	}
	
}
