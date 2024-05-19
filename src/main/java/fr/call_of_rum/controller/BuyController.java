package fr.call_of_rum.controller;

import fr.call_of_rum.model.item.Item;
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
        int price = market.getPrice(itemIndex);
        
        int savings = pirate.getCoins();
        if (savings >= price) {
    		Item boughtItem = market.getItem(itemIndex);
        	takeItemController.takeItem(pirate, boughtItem);
        	pirate.setCoins(savings - price);
        }
	}
	
}
