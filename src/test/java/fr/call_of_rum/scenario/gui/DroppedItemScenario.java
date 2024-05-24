package fr.call_of_rum.scenario.gui;

import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.stubs.ItemStub;
import java.util.Random;
import java.util.random.RandomGenerator;


public class DroppedItemScenario extends GUIScenario {
    private RandomGenerator rng=new Random();
	
	public DroppedItemScenario() {
		super();
		super.board = BoardFactory.getDefaultBoard(super.itemRegistry,rng);
		Item item1 = new ItemStub();
		Item item2 = new ItemStub();
		super.player1.give(item1);
		super.player1.give(item2);
		super.board.movePirateTo(player1, 10);
		//item1.drop();
		//super.board.movePirateTo(player1, 24);
		//item2.drop();
	}
	
	public static void main(String[] args) {
		DroppedItemScenario scenario = new DroppedItemScenario();
		scenario.start();
	}
	
}
