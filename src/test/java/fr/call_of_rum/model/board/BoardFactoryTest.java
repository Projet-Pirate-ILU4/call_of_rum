package fr.call_of_rum.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

import fr.call_of_rum.model.board.cells.Chest;
import fr.call_of_rum.model.board.cells.Land;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.item.liquid.Rum;

public class BoardFactoryTest {

	@Test
	public void chestTest() {
		BoardFactory factory = BoardFactory.getFactory();
		factory.setSpecialCaseOdds(1.0f);
		factory.setChestOdds(1.0f);
		Board board = factory.build(new ItemRegistry().registerItem(Rum::new), new Random());
		assertEquals(Land.class, board.getCell(0).getClass());
		for (int i = 1; i < board.getBoardSize()-1; i++) {
			assertEquals(Chest.class, board.getCell(i).getClass());
			Chest chest = (Chest) board.getCell(i);
			assertNotNull(chest.getItem());
		}
		assertEquals(Land.class, board.getCell(board.getBoardSize()).getClass());
	}
	
	// TODO continue tests

}
