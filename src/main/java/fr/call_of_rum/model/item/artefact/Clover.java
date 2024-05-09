package fr.call_of_rum.model.item.artefact;

import fr.call_of_rum.model.item.Item;

public class Clover extends Item {
	
	private static final String NAME = "Clover";
	private static final String DESCRIPTION = "Grant +50% of gold earnings";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
	// TODO find a way to implements passive effects
	
}
