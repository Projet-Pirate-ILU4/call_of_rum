package fr.call_of_rum.boundary;

public interface IGraphicInterface {
	
	void giveTurn(int player);
	
	void printMessage(String msg);
	
	void clearMessages();
	
	void close();
	
}
