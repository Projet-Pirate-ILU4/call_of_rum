package fr.call_of_rum.scenario.tui;

import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.stubs.ItemStub;

public class DroppedItemScenario extends TUIScenario {
	
	public DroppedItemScenario() {
		super();
		super.board = BoardFactory.getDefaultBoard(super.itemRegistry);
		Item item = new ItemStub();
		super.player1.give(item);
		super.board.addPirate(player1);
		item.drop();
	}
	
	public static void main(String[] args) {
		DroppedItemScenario scenario = new DroppedItemScenario();
		scenario.start();
	}
	
}
