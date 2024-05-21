package fr.call_of_rum.scenario;

import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.artefact.Clover;
import fr.call_of_rum.util.ItemType;

public class ExampleScenario extends GUIScenario {
	
	public static void main(String[] args) {
		ExampleScenario scenario = new ExampleScenario();
		// edit inputs
        scenario.board=BoardFactory.getFactory()
                        .setChestOdds(1.0f)
                        .setSpecialCaseOdds(1.0f)
                        .build(scenario.itemRegistry);
        Item clover=new Clover();
        scenario.pirate1.give(clover);
        scenario.pirate1.setBoard(scenario.board);
        scenario.board.addPirate(scenario.pirate1);
        clover.drop();
		scenario.start();
	}

}
