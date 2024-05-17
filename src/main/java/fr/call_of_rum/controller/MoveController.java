package fr.call_of_rum.controller;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.pirate.Pirate;

public class MoveController {
	
	private DiceController diceController;
	private TriggerCellController triggerCellController;
	
	private Board board;
	
	public MoveController(DiceController diceController, TriggerCellController triggerCellController, Board board) {
		this.diceController = diceController;
		this.triggerCellController = triggerCellController;
		this.board = board;
	}
	
	public void movePirate(Pirate pirate) {
		int pirateLocation = board.getPirateLocation(pirate);
		int newLocation = pirateLocation + diceController.getDiceResult();
		board.movePirateTo(pirate, newLocation);
		triggerCellController.triggerCell(board.getCell(newLocation), pirate);
	}
	
}
