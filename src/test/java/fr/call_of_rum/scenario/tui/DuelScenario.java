package fr.call_of_rum.scenario.tui;

import java.util.random.RandomGenerator;

import fr.call_of_rum.model.board.BoardFactory;

public class DuelScenario extends TUIScenario {
	
	public DuelScenario() {
		super.board = BoardFactory.getFactory()
				.setSpecialCaseOdds(0.0f)
				.build(itemRegistry, super.rng);
		// set next dice results to always 6
		super.rng = new RandomGenerator() {
			@Override
			public long nextLong() {
				throw new UnsupportedOperationException("rng.nextLont()");
			}
			@Override
			public int nextInt(int bound) {
				return 2;
			}
		};
	}
	
	public static void main(String[] args) {
		DuelScenario scenario = new DuelScenario();
		scenario.start();
	}
	
}
