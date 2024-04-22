package fr.call_of_rum.controller;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.model.ExampleModel;

public class ExampleController implements IDownCall {
	
	private ExampleModel exampleModel;
	private IBoundary boundary;
	
	public ExampleController(ExampleModel exampleModel, IBoundary boundary) {
		this.exampleModel = exampleModel;
		this.boundary = boundary;
	}
	
	public void downcall() {
		exampleModel.doSomething();
		boundary.upcall();
	}
	
}
