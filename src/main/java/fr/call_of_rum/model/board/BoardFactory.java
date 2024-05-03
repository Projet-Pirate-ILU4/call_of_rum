package fr.call_of_rum.model.board;

public class BoardFactory {
	
	private BoardFactory() {}
	
	public static BoardFactory getFactory() {
		return new BoardFactory();
	}
	
	public Board build() {
		return new Board();
	}
	
	public static Board getDefaultBoard() {
		return new BoardFactory().build();
	}
	
}
