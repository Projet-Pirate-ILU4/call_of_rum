package fr.call_of_rum.model.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.pirate.Inventory;
import fr.call_of_rum.model.pirate.NoFreeSlotException;
import fr.call_of_rum.model.stubs.ItemStub;

public class InventoryTest {
	
	private Inventory inv;
	private Item item1;
	private Item item2;

	@Before
	public void setUp() throws Exception {
		inv = new Inventory(3);
		item1 = new ItemStub();
		item2 = new ItemStub();
	}

	@Test
	public void addTest() {
		inv.add(item1);
		inv.add(item2);
		assertEquals(item1, inv.get(0));
		assertEquals(item2, inv.get(1));
		inv.add(item1);
		assertThrows(NoFreeSlotException.class, () -> inv.add(item1));
	}
	
	@Test
	public void insertTest() {
		inv.insert(item1, 2);
		inv.insert(item2, 1);
		assertEquals(item1, inv.get(2));
		assertEquals(item2, inv.get(1));
	}
	
	@Test
	public void removeTest() {
		inv.add(item1);
		inv.add(item2);
		inv.removeItem(item1);
		assertNull(inv.get(0));
		assertEquals(item2, inv.get(1));
	}
	
	@Test
	public void containsTest() {
		assertFalse(inv.contains(item1));
		inv.add(item1);
		assertTrue(inv.contains(item1));
	}

}
