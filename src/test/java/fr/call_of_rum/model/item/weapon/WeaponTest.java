package fr.call_of_rum.model.item.weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;
import util.stub.WeaponStub;

public class WeaponTest {
	
	private static final double DELTA = 0.000001;
	
	private static final float FIGHT_BONUS = 0.2f;
	private static final int DAMAGES = 2;
	private static final float STEALING_POTENTIAL = 0.3f;
	
	private Pirate pirate;
	private Weapon weapon1;
	private Weapon weapon2;
	
	@Before
	public void setUp() throws Exception {
		pirate = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 10);
		weapon1 = new WeaponStub(ItemType.FLINTLOCK_PISTOL, FIGHT_BONUS, DAMAGES, STEALING_POTENTIAL);
		weapon2 = new WeaponStub(ItemType.SABER, FIGHT_BONUS, DAMAGES, STEALING_POTENTIAL);
		pirate.give(weapon1);
		pirate.give(weapon2);
	}
	
	@Test
	public void validAttributesTest() {
		assertEquals(FIGHT_BONUS, weapon1.getFightBonus(), DELTA);
		assertEquals(DAMAGES, weapon1.getDamages(), DELTA);
		assertEquals(STEALING_POTENTIAL, weapon1.getStealingPotential(), DELTA);
	}

	@Test
	public void useTest() {
		assertNotSame(weapon1, pirate.getEquippedWeapon());
		assertNotSame(weapon2, pirate.getEquippedWeapon());
		assertTrue(pirate.getInventory().contains(weapon1));
		assertTrue(pirate.getInventory().contains(weapon2));
		weapon1.use();
		assertSame(weapon1, pirate.getEquippedWeapon());
		assertFalse(pirate.getInventory().contains(weapon1));
		assertTrue(pirate.getInventory().contains(weapon2));
		weapon2.use();
		assertSame(weapon2, pirate.getEquippedWeapon());
		assertTrue(pirate.getInventory().contains(weapon1));
		assertFalse(pirate.getInventory().contains(weapon2));
	}

}
