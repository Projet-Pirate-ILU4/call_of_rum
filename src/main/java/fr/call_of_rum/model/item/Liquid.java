package fr.call_of_rum.model.item;

import fr.call_of_rum.model.pirate.IntoxicationGauge;

public abstract class Liquid extends UseableItem {
	
	protected int recovery;
	protected float intoxication;
	
	protected Liquid(int recovery, float intoxication) {
		this.recovery = recovery;
		this.intoxication = intoxication;
	}

	@Override
	public void use() {
		if (owner == null) return;
		owner.setHealthPoints(owner.getHealthPoints() + recovery);
		IntoxicationGauge gauge = owner.getIntoxicationGauge();
		gauge.setLevel(gauge.getLevel() + intoxication);
	}

}
