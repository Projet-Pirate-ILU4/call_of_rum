package fr.call_of_rum.model;

import fr.call_of_rum.boundary.IBoundary;

public class ExampleModel {
	
	private IBoundary boundary;
	
	public void setBoundary(IBoundary boundary) {
		this.boundary = boundary;
	}
	
	public void downcall() {
		boundary.upcall();
	}
	
}
