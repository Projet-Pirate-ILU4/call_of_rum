package fr.call_of_rum.controller;

import fr.call_of_rum.model.ExampleModel;

public class ExampleController {
	
	private ExampleModel exampleModel;
	
	public ExampleController(ExampleModel exampleModel) {
		this.exampleModel = exampleModel;
	}
	
	public void downcall() {
		exampleModel.downcall();
	}
	
}
