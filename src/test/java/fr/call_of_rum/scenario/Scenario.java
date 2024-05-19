package fr.call_of_rum.scenario;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public abstract class Scenario {
	
	protected ItemRegistry itemRegistry = new ItemRegistry();
	protected Board board = BoardFactory.getDefaultBoard(itemRegistry);
	protected Market market = new Market();
	protected Pirate player2 = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 10);
	protected Pirate player1 = new Pirate(Player.JACK_LE_BORGNE, 0, 10);
	
	public abstract void start();
	
}
