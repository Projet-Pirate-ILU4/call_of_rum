package fr.call_of_rum.boundary;

import fr.call_of_rum.boundary.dialog.ExampleDialog;
import fr.call_of_rum.controller.ExampleController;

public class ExampleFunctionalKernelAdapter implements IBoundary {
	
	private ExampleDialog exampleDialog;
	private ExampleController exampleController;
	
	public ExampleFunctionalKernelAdapter(ExampleController exampleController) {
		this.exampleController = exampleController;
	}
	
	public void setDialog(ExampleDialog exampleDialog) {
		this.exampleDialog = exampleDialog;
	}
	
	public void downcall() {
		exampleController.downcall();
	}

	@Override
	public void upcall() {
		exampleDialog.upcall();
	}

}
