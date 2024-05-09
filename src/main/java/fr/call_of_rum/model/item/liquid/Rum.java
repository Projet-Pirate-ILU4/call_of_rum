package fr.call_of_rum.model.item.liquid;

public class Rum extends Liquid {
	
	private static final String NAME = "Rum";
	private static final String DESCRIPTION = "Heal 2 HealthPoint but intoxicate you";

	public Rum() {
		super(2, 0.4f);
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
