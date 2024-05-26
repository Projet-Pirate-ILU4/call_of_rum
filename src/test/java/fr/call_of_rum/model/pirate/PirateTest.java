package fr.call_of_rum.model.pirate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;
import util.stub.ItemStub;
import util.stub.LiquidStub;
import util.stub.WeaponStub;

public class PirateTest {
	
	private static final double DELTA = 0.000001;
	
	private static final int MAX_HEALTH = 10;
	private static final int STARTING_COINS = 0;
	private static final Player PLAYER = Player.BILL_JAMBE_DE_BOIS;
	
	private Pirate pirate;

	@Before
	public void setUp() throws Exception {
		pirate = new Pirate(PLAYER, STARTING_COINS, MAX_HEALTH);
	}
	
	@Test
	public void correctAttributeValuesTest() {
		assertNull(pirate.getBoard());
		Board board = BoardFactory.getDefaultBoard(new ItemRegistry(), new Random());
		pirate.setBoard(board);
		assertEquals(board, pirate.getBoard());
		assertEquals(MAX_HEALTH, pirate.getMaxHealth());
		assertEquals(MAX_HEALTH, pirate.getHealthPoints());
		assertEquals(STARTING_COINS, pirate.getCoins());
		Weapon weapon = new WeaponStub(ItemType.DAGGER, 0.0f, 0, 0.0f);
		pirate.equipWeapon(weapon);
		assertEquals(weapon, pirate.getEquippedWeapon());
		assertEquals(0.0f, pirate.getIntoxicationGauge().getLevel(), DELTA);
		assertEquals(0, pirate.getLocation());
		assertEquals(PLAYER, pirate.getPlayer());
	}

	@Test
	public void giveTest() {
		Item item = new ItemStub();
		pirate.give(item);
		assertEquals(pirate, item.getOwner());
		assertTrue(pirate.getInventory().contains(item));
	}
	
	@Test
	public void drinkTest() {
		Liquid liquid = new LiquidStub(2, 0.2f);
		pirate.setHealthPoints(MAX_HEALTH - 2);
		pirate.drink(liquid);
		assertEquals(MAX_HEALTH, pirate.getHealthPoints());
		assertEquals(0.2f, pirate.getIntoxicationGauge().getLevel(), DELTA);
	}

}
