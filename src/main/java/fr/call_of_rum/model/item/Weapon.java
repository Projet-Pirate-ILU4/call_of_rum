package fr.call_of_rum.model.item;

public abstract class Weapon extends UseableItem {
	
	private float fightBonus;
	private int damages;
	private int stealingPotential;

	protected Weapon(float fightBonus, int damages, int stealingPotential) {
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
	
	public int getStealingPotential() {
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
