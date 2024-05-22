package fr.call_of_rum.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public class BoardTest {
	
	private Pirate pirate;
	private Pirate otherPirate;
	private Board board;

	@Before
	public void setUp() throws Exception {
		pirate = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 5);
		otherPirate = new Pirate(Player.JACK_LE_BORGNE, 0, 5);
		board = BoardFactory.getDefaultBoard(new ItemRegistry() /* empty registry */);
		pirate.setBoard(board);
		otherPirate.setBoard(board);
	}

	@Test
	public void movePirateTest() {
		// test move pirate to cell number
		board.movePirateTo(pirate, 4);
		assertEquals(4, pirate.getLocation());
		
		// test edge case with big values
		board.movePirateTo(pirate, (board.getBoardSize() * 10));
		assertEquals(0, pirate.getLocation());
		
		// test edge case with no movement
		int previousLocation = pirate.getLocation();
		board.movePirateTo(pirate, pirate.getLocation());
		assertEquals(previousLocation, pirate.getLocation());
		
		// test move pirate to pirate
		board.movePirateTo(pirate, otherPirate);
		assertEquals(pirate.getLocation(), otherPirate.getLocation());
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
		previousLocation = pirate.getLocation();
		board.movePirateToMerchant(pirate);
		// pirate didn't moved because he's not in the correct area
		assertEquals(previousLocation, pirate.getLocation());
		moveUntilInZone();
		// now the pirate should be in the area
		assertFalse(board.isPirateOnMerchant(pirate));
		board.movePirateToMerchant(pirate);
		assertTrue(board.isPirateOnMerchant(pirate));
	}

}
