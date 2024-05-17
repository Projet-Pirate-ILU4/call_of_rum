package fr.call_of_rum.controller;

import java.util.Random;

public class DiceController {
	
	private static final Random RNG = new Random();
	
	private int diceResult;
	
	public int getDiceResult() {
		return diceResult;
	}
	
	public void rollDices() {
		int firstDiceResult = RNG.nextInt(6) + 1;
		int secondDiceResult = RNG.nextInt(6) + 1;
		diceResult = firstDiceResult + secondDiceResult;
	}

}
