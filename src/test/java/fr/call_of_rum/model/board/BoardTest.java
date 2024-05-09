package fr.call_of_rum.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.pirate.Pirate;

public class BoardTest {
	
	private Pirate pirate;
	private Board board;

	@Before
	public void setUp() throws Exception {
		pirate = new Pirate("pirate", 0, 5);
		board = BoardFactory.getDefaultBoard();
		board.addPirate(pirate);
	}

	@Test
	public void movePirateTest() {
		board.movePirate(pirate, 4);
		assertEquals(4, board.getCellOf(pirate).getNum());
		board.movePirate(pirate, 10000);
		assertTrue(board.getCellOf(pirate).getNum() < 10000);
	}
	
	@Test
	public void moveToMerchant() {
		Cell cellBeforeMove = board.getCellOf(pirate);
		board.moveToMerchant(pirate);
		// pirate didn't moved because he's not in the correct area
		assertEquals(cellBeforeMove, board.getCellOf(pirate));
		
		board.movePirate(pirate, 10);
		// now the pirate should be in the area
		cellBeforeMove = board.getCellOf(pirate);
		board.moveToMerchant(pirate);
		assertNotEquals(cellBeforeMove, board.getCellOf(pirate));
		assertEquals(board.getMerchantcell(), board.getCellOf(pirate));
	}

}
