package fr.call_of_rum.boundary.dialog;

import java.awt.EventQueue;

import fr.call_of_rum.boundary.ExampleFunctionalKernelAdapter;
import fr.call_of_rum.boundary.presentation.ExamplePresentation;

public class ExampleDialog {
	
	private ExamplePresentation examplePresentation;
	private ExampleFunctionalKernelAdapter exampleFunctionalKernelAdapter;
	
	public ExampleDialog(ExampleFunctionalKernelAdapter exampleFunctionalKernelAdapter) {
		this.examplePresentation = new ExamplePresentation();
		this.examplePresentation.setDialog(this);
		this.exampleFunctionalKernelAdapter = exampleFunctionalKernelAdapter;
	}
	
	public void initDialog() {
            EventQueue.invokeLater(() -> examplePresentation.setVisible(true));
	}
	
	public void downcall() {
		exampleFunctionalKernelAdapter.downcall();
	}
	
	public void upcall() {
		examplePresentation.upcall();
	}
	
}
