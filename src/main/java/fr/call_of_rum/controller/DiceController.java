package fr.call_of_rum.controller;

import java.util.random.RandomGenerator;

import fr.call_of_rum.controller.accessible.IDiceController;

public class DiceController implements IDiceController {
	
	private RandomGenerator rng;
	
	private int diceResult;
	
	public DiceController(RandomGenerator rng) {
		this.rng = rng;
	}
	
	@Override
	public int getDiceResult() {
		return diceResult;
	}
	
	public void rollDices() {
		int firstDiceResult = rng.nextInt(6) + 1;
		int secondDiceResult = rng.nextInt(6) + 1;
		diceResult = firstDiceResult + secondDiceResult;
	}

}
