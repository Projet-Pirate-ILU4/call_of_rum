package fr.call_of_rum.model.item.weapon;

public class Saber extends Weapon {
	
	private static final float FIGHT_BONUS = 0.2f;
	private static final int DAMAGES = 4;
	private static final float STEALING_POTENTIAL = 0.6f;
	
	private static final String NAME = "Saber";
	private static final String DESCRIPTION = "";
	
	public Saber() {
		super(FIGHT_BONUS, DAMAGES, STEALING_POTENTIAL);
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
