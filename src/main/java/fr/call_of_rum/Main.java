package fr.call_of_rum;

import fr.call_of_rum.boundary.ExampleBoundary;
import fr.call_of_rum.boundary.ExampleFunctionalKernelAdapter;
import fr.call_of_rum.boundary.dialog.ExampleDialog;
import fr.call_of_rum.controller.ExampleController;
import fr.call_of_rum.model.ExampleModel;

public class Main {
   
    public String getGreeting() {
         return "Hello World, this is Main!";
    }

    @SuppressWarnings("unused")
    private static void launchOnTUI() {
    	// boundary initialization
    	ExampleBoundary exampleBoundary = new ExampleBoundary();
    	
    	// model initialization
    	ExampleModel exampleModel = new ExampleModel(); // ...
    	
    	// controller initialization
    	ExampleController exampleController = new ExampleController(exampleModel, exampleBoundary); // ...
    	
    	// wiring IBoundary and IFunctionalKernel
    	exampleBoundary.setDownCallController(exampleController);
    	
    	// launch
    	exampleBoundary.launch();
    }
    
    @SuppressWarnings("unused")
	private static void launchOnGUI() {
    	// boundary initialization
    	ExampleFunctionalKernelAdapter functionalKernelAdapter = new ExampleFunctionalKernelAdapter();
    	ExampleDialog exampleDialog = new ExampleDialog(functionalKernelAdapter);
    	
    	// model initialization
    	ExampleModel exampleModel = new ExampleModel(); // ...
    	
    	// controller initialization
    	ExampleController exampleController = new ExampleController(exampleModel, functionalKernelAdapter); // ...
    	
    	// wiring IBoundary and IFunctionalKernel
    	functionalKernelAdapter.setDialog(exampleDialog);
    	functionalKernelAdapter.setDownCallController(exampleController);
    	
    	// launch
    	exampleDialog.initDialog();
    }

    public static void main(String[] args) {
    	launchOnTUI();
    }

}