package fr.call_of_rum.model.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.model.stubs.ItemStub;

public class ItemTest {
	
	private Pirate pirate;
	private Board board;
	private Item item;

	@Before
	public void setUpBeforeClass() throws Exception {
		pirate = new Pirate("pirate", 0, 5);
		item = new ItemStub();
		board = BoardFactory.getDefaultBoard(new ItemRegistry() /* empty registry */);
		pirate.give(item);
		board.addPirate(pirate);
	}

	@Test
	public void dropTest() {
		assertTrue(pirate.getInventory().contains(item));
		assertFalse(board.getCell(pirate).getAllItems().contains(item));
		assertEquals(pirate, item.getOwner());
		item.drop();
		assertFalse(pirate.getInventory().contains(item));
		assertTrue(board.getCell(pirate).getAllItems().contains(item));
		assertNull(item.getOwner());
	}

}
