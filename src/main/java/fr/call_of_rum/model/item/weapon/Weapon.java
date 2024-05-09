package fr.call_of_rum.model.item.weapon;

import fr.call_of_rum.model.item.UseableItem;

public abstract class Weapon extends UseableItem {
	
	private float fightBonus;
	private int damages;
	private float stealingPotential;

	protected Weapon(float fightBonus, int damages, float stealingPotential) {
		this.fightBonus = fightBonus;
		this.damages = damages;
		this.stealingPotential = stealingPotential;
	}
	
	public float getFightBonus() {
		return fightBonus;
	}
	
	
	public int getDamages() {
		return damages;
	}
	
	public float getStealingPotential() {
		return stealingPotential;
	}
	
	@Override
	public void use() {
		if (owner == null) return;
		Weapon previouslyEquippedWeapon = owner.getEquippedWeapon();
		if (previouslyEquippedWeapon != null)
			owner.getInventory().add(previouslyEquippedWeapon);
		owner.equipWeapon(this);
	}

}
