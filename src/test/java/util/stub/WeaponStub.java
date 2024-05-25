package util.stub;

import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.util.ItemType;

public class WeaponStub extends Weapon {

	public WeaponStub(ItemType itemType, float fightBonus, int damages, float stealingPotential) {
		super(itemType, fightBonus, damages, stealingPotential);
	}

}
