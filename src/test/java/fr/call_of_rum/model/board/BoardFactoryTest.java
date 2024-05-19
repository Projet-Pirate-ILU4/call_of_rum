package fr.call_of_rum.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fr.call_of_rum.model.board.cells.Chest;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.item.liquid.Rum;

public class BoardFactoryTest {

	@Test
	public void chestTest() {
		BoardFactory factory = BoardFactory.getFactory();
		factory.setSpecialCaseOdds(1.0f);
		factory.setChestOdds(1.0f);
		Board board = factory.build(new ItemRegistry().registerItem(Rum::new));
		for (int i = 0; i < board.getBoardSize(); i++) {
			assertEquals(Chest.class, board.getCell(i).getClass());
			Chest chest = (Chest) board.getCell(i);
			assertNotNull(chest.getItem());
		}
	}
	
	// TODO continue tests

}
