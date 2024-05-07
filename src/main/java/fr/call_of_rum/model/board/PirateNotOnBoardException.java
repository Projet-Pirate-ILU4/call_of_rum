package fr.call_of_rum.model.board;

import fr.call_of_rum.model.pirate.Pirate;

public class PirateNotOnBoardException extends RuntimeException {
	
	private static final long serialVersionUID = -679971006728098939L;

	public PirateNotOnBoardException(Pirate pirate) {
		super("Pirate " + pirate.toString() + " is not on board.");
	}
	
}
