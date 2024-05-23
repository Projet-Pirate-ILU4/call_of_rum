package fr.call_of_rum.scenario.tui;

import java.util.random.RandomGenerator;

import fr.call_of_rum.controller.DiceController;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.weapon.Saber;

public class DuelScenario extends TUIScenario {
	
	private static final RandomGenerator CONSTANT_RANDOM = new RandomGenerator() {
		@Override
		public long nextLong() {
			throw new UnsupportedOperationException("rng.nextLong()");
		}
		@Override
		public int nextInt(int bound) {
			return 2;
		}
	};
	
	public DuelScenario() {
		super.board = BoardFactory.getFactory()
				.setSpecialCaseOdds(0.0f)
				.build(itemRegistry, super.rng);
		// set next dice results to always 6
		super.diceController = new DiceController(CONSTANT_RANDOM);
		super.player1.setCoins(100);
		super.player2.setCoins(100);
		super.player1.equipWeapon(new Saber());
	}
	
	public static void main(String[] args) {
		DuelScenario scenario = new DuelScenario();
		scenario.start();
	}
	
}
