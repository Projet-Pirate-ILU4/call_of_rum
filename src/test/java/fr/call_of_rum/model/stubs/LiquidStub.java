package fr.call_of_rum.model.stubs;

import fr.call_of_rum.model.item.liquid.Liquid;

public class LiquidStub extends Liquid {

	public LiquidStub(int recovery, float intoxication) {
		super(recovery, intoxication);
	}

	@Override
	public String getName() {
		return "Liquid Stub";
	}

	@Override
	public String getDescription() {
		return "A stub Liquid object for testing";
	}

}
