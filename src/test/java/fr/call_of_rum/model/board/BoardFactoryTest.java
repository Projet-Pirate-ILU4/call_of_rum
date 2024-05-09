package fr.call_of_rum.model.board;

import static org.junit.Assert.assertEquals;

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
		Board board = factory.build(new ItemRegistry().registerItem(Rum.class));
		for (int i = 0; i < board.getBoardSize(); i++) {
			assertEquals(Chest.class, board.getCell(i).getClass());
		}
	}
	
	// TODO continue tests

}
