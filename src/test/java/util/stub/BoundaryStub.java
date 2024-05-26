package util.stub;

import java.util.Optional;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public class BoundaryStub implements IBoundary {

	@Override
	public void giveTurn(Player player) {
	}

	@Override
	public void stepOnBomb() {
	}

	@Override
	public void tookShortcut() {
	}

	@Override
	public boolean chestFound(int coinAmount, ItemType itemNamespace) {
		return false;
	}

	@Override
	public boolean openedChestFound(int coinAmount, Optional<ItemType> itemNamespace) {
		return false;
	}

	@Override
	public void duel(Player winner) {
	}

	@Override
	public void gameEnded(Player winner) {
	}

}
