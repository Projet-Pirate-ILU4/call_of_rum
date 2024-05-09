package fr.call_of_rum.boundary;

/**
 * This interface contains all functionalities that a boundary should provide.
 */
public interface IBoundary {
	
	void giveTurn(int player);
	
	void gameEnded(int winner);
	
}
