package fr.call_of_rum.scenario.tui;

import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.liquid.Rum;

public class ChestScenario extends TUIScenario {
	
	public ChestScenario() {
		super();
		super.itemRegistry.registerItem(Rum::new);
		super.board = BoardFactory.getFactory()
				.setSpecialCaseOdds(1.0f)
				.setChestOdds(1.0f)
				.build(super.itemRegistry, super.rng);
	}
	
	public static void main(String[] args) {
		ChestScenario scenario = new ChestScenario();
		scenario.start();
	}
	
}
