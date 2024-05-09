package fr.call_of_rum.controller;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public class MoveController implements IMoveController {
	
	private GameController gameController;
	private TriggerCellController triggerCellController;
	
	private Board board;
	
	public MoveController(GameController gameController, TriggerCellController triggerCellController, Board board) {
		this.gameController = gameController;
		this.triggerCellController = triggerCellController;
		this.board = board;
	}
	
	@Override
	public void movePlayer(Player player, int cellNumber) {
		if (player == null) return;
		Pirate pirate = gameController.getPirate(player);
		Cell cell = board.getCell(cellNumber);
		// TODO ask user for cell items
		triggerCellController.triggerCell(cell, pirate);
	}
	
}
