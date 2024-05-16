package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.controller.TriggerCellController;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public class MoveControllerImpl implements MoveController {
	
	private TriggerCellController triggerCellController;
	
	private Board board;
	private Pirate[] pirates = new Pirate[2];
	
	public MoveControllerImpl(TriggerCellController triggerCellController, Board board, Pirate player1, Pirate player2) {
		this.triggerCellController = triggerCellController;
		this.board = board;
		pirates[0] = player1;
		pirates[1] = player2;
	}
	
	@Override
	public void movePlayer(Player player, int cellNumber) {
		if (player == null) return;
		Pirate pirate = pirates[player.ordinal()];
		Cell cell = board.getCell(cellNumber);
		// TODO ask user for cell items
		triggerCellController.triggerCell(cell, pirate);
	}
	
}
