package fr.call_of_rum.scenario.tui;

import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.liquid.Rum;
import util.stub.ItemStub;

public class DroppedItemScenario extends TUIScenario {
	
	public DroppedItemScenario() {
		super();
		super.itemRegistry.registerItem(Rum::new);
		super.board = BoardFactory.getDefaultBoard(super.itemRegistry, super.rng);
		Item item = new ItemStub();
		super.player1.give(item);
		super.player1.setBoard(super.board);
		item.drop();
	}
	
	public static void main(String[] args) {
		DroppedItemScenario scenario = new DroppedItemScenario();
		scenario.start();
	}
	
}
