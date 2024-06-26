package fr.call_of_rum.model.item.liquid;

import fr.call_of_rum.model.item.UseableItem;
import fr.call_of_rum.model.pirate.IntoxicationGauge;
import fr.call_of_rum.util.ItemType;

public abstract class Liquid extends UseableItem {
	
	protected int recovery;
	protected float intoxication;
	
	protected Liquid(ItemType itemType, int recovery, float intoxication) {
		super(itemType);
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
