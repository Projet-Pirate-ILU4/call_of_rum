package fr.call_of_rum.model.item.artefact;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.util.ArtefactType;

public class Clover extends Item {

	private static final String NAMESPACE = ArtefactType.CLOVER.toString();
	
	public Clover() {
		super(NAMESPACE);
	}
	
}
