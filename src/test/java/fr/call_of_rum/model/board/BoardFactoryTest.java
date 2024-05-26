package fr.call_of_rum.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import java.util.Random;

import org.junit.Test;

import fr.call_of_rum.model.board.cells.Chest;
import fr.call_of_rum.model.board.cells.Trap;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.item.liquid.Rum;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;

public class BoardFactoryTest {
	
	@Test
	public void firstAndLastCellTest() {
		Board board = BoardFactory.getFactory()
				.setSpecialCaseOdds(1.0f)
				.setNumberOfCells(8) // the number of cells don't matters
				.build(new ItemRegistry(), new Random());
		assertEquals(CellType.NORMAL, board.getCell(0).getType());
		assertEquals(CellType.NORMAL, board.getCell(board.getBoardSize()).getType());
	}
	
	@Test
	public void chestTest() {
		BoardFactory factory = BoardFactory.getFactory()
				.setSpecialCaseOdds(1.0f) // all cells (except the first and last cell) are special
				.setChestOdds(1.0f) // a special cell is always a chest
				.setChestGoldBounds(new int[] {15, 16}); // a chest always has exactly 15 golds
		ItemRegistry itemRegistry = new ItemRegistry().registerItem(Rum::new); // a chest always has rum inside it
		Board board = factory.build(itemRegistry, new Random());
		int merchantIndex = board.getMerchantCellNumber();
		for (int i = 1; i < board.getBoardSize()-1; i++) {
			if (i == merchantIndex) continue;
			
			assertEquals(CellType.CHEST, board.getCell(i).getType());
			Chest chest = (Chest) board.getCell(i);
			assertFalse(chest.isOpened());
			assertEquals(ItemType.RUM, chest.getItem().getType());
			assertEquals(15, chest.getCoins());
		}
	}
	
	@Test
	public void trapTest() {
		Board board = BoardFactory.getFactory()
				.setSpecialCaseOdds(1.0f) // all cells (except the first and last cell) are special
				.setChestOdds(0.0f) // a special cell is always a trap
				.build(null, new Random());
		
		int merchantIndex = board.getMerchantCellNumber();
		for (int i = 1; i < board.getBoardSize()-1; i++) {
			if (i == merchantIndex) continue;
			
			final int index = i;
			assertTrue(Arrays.stream(new CellType[] {CellType.BOMB, CellType.SHORTCUT}).anyMatch(c -> board.getCell(index).getType() == c));
			Trap trap = (Trap) board.getCell(index);
			assertNotNull(trap.getTrapType());
		}
	}
	
	@Test
	public void storeTest() {
		Board board = BoardFactory.getFactory()
				.setMerchantPossibleCells(new int[] {15})
				.build(new ItemRegistry(), new Random());
		assertEquals(CellType.MERCHANT, board.getCell(15).getType());
	}
	
	@Test
	public void validCellsTest() {
		Board board = BoardFactory.getDefaultBoard(new ItemRegistry(), new Random());
		for (int i = 0; i < board.getBoardSize()-1; i++) {
			assertEquals(i, board.getCell(i).getNum());
			assertTrue(board.getCell(i).getDroppedItems().isEmpty());
		}
	}
	
}
