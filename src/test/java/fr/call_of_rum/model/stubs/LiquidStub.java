package fr.call_of_rum.model.stubs;

import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.util.ItemType;

public class LiquidStub extends Liquid {

	public LiquidStub(int recovery, float intoxication) {
		super(ItemType.RUM, recovery, intoxication);
	}

}
