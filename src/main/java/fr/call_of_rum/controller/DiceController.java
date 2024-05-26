package fr.call_of_rum.controller;

import java.util.random.RandomGenerator;

import fr.call_of_rum.controller.accessible.IDiceController;

public class DiceController implements IDiceController {
	
	private RandomGenerator rng;
	
	private int firstDiceResult;
	private int secondDiceResult;
	
	public DiceController(RandomGenerator rng) {
		this.rng = rng;
	}
	
	@Override
	public int getFirstDiceResult() {
		return firstDiceResult;
	}
	
	@Override
	public int getSecondDiceResult() {
		return secondDiceResult;
	}
	
	@Override
	public int getDicesResult() {
		return firstDiceResult + secondDiceResult;
	}
	
	public void rollDices() {
		firstDiceResult = rng.nextInt(6) + 1;
		secondDiceResult = rng.nextInt(6) + 1;
	}

}
