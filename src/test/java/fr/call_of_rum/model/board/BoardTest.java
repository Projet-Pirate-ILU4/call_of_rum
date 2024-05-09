package fr.call_of_rum.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.pirate.Pirate;

public class BoardTest {
	
	private Pirate pirate;
	private Pirate otherPirate;
	private Board board;

	@Before
	public void setUp() throws Exception {
		pirate = new Pirate("pirate", 0, 5);
		pirate = new Pirate("other pirate", 0, 5);
		board = BoardFactory.getDefaultBoard(new ItemRegistry() /* empty registry */);
		board.addPirate(pirate);
	}

	@Test
	public void movePirateTest() {
		int previousLocation;
		// test move pirate to cell number
		board.movePirateTo(pirate, 4);
		assertEquals(4, board.getCell(pirate).getNum());
		// test edge case with big values
		previousLocation = board.getPirateLocation(pirate);
		board.movePirateTo(pirate, 10000);
		assertEquals(previousLocation, board.getPirateLocation(pirate));
		// test edge case with no movement
		previousLocation = board.getPirateLocation(pirate);
		board.movePirateTo(pirate, 0);
		assertEquals(previousLocation, board.getPirateLocation(pirate));
		// test move pirate to pirate
		board.movePirateTo(pirate, otherPirate);
		assertEquals(board.getPirateLocation(pirate), board.getPirateLocation(otherPirate));
	}
	
	private void moveUntilNotInZone() {
		int i = 0;
		while (board.canMoveToMerchant(pirate)) {
			board.movePirateTo(pirate, i++);
		}
	}
	
	private void moveUntilInZone() {
		int i = 0;
		while (!board.canMoveToMerchant(pirate) || board.isPirateOnMerchant(pirate)) {
			board.movePirateTo(pirate, i++);
		}
	}
	
	@Test
	public void movePirateToMerchantTest() {
		moveUntilNotInZone();
		int previousLocation;
		previousLocation = board.getPirateLocation(pirate);
		board.movePirateToMerchant(pirate);
		// pirate didn't moved because he's not in the correct area
		assertEquals(previousLocation, board.getPirateLocation(pirate));
		moveUntilInZone();
		// now the pirate should be in the area
		assertFalse(board.isPirateOnMerchant(pirate));
		board.movePirateToMerchant(pirate);
		assertTrue(board.isPirateOnMerchant(pirate));
	}

}
