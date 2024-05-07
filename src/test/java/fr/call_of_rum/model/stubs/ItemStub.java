package fr.call_of_rum.model.stubs;

import fr.call_of_rum.model.item.Item;

public class ItemStub extends Item {
	
	@Override
	public String getName() {
		return "Item Stub";
	}
	
	@Override
	public String getDescription() {
		return "A stub Item object for testing";
	}
	
}
