package fr.call_of_rum.model.item.liquid;

import fr.call_of_rum.util.LiquidType;

public class Rum extends Liquid {
	
	private static final String NAMESPACE = LiquidType.RUM.toString().toLowerCase();
	
	private static final int RECOVERY = 2;
	private static final float INTOXICATION = 0.4f;

	public Rum() {
		super(NAMESPACE, RECOVERY, INTOXICATION);
	}

}
