package fr.call_of_rum.boundary.dialog;

import java.awt.EventQueue;

import fr.call_of_rum.boundary.IFunctionalKernel;
import fr.call_of_rum.boundary.IGraphicInterface;
import fr.call_of_rum.boundary.presentation.ExamplePresentation;

public class ExampleDialog implements IGraphicInterface {
	
	private ExamplePresentation examplePresentation;
	private IFunctionalKernel functionalKernel;
	
	public ExampleDialog(IFunctionalKernel functionalKernel) {
		this.examplePresentation = new ExamplePresentation();
		this.examplePresentation.setDialog(this);
		this.functionalKernel = functionalKernel;
	}
	
	public void initDialog() {
            EventQueue.invokeLater(() -> examplePresentation.setVisible(true));
	}
	
	public void downcall() {
		functionalKernel.downcall();
	}
	
	public void upcall() {
		examplePresentation.upcall();
	}
	
}
