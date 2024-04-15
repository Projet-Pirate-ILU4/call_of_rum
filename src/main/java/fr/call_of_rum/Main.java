package fr.call_of_rum;

import fr.call_of_rum.boundary.ExampleFunctionalKernelAdapter;
import fr.call_of_rum.boundary.dialog.ExampleDialog;
import fr.call_of_rum.controller.ExampleController;
import fr.call_of_rum.model.ExampleModel;

public class Main {
   
    public String getGreeting() {
         return "Hello World, this is Main!";
    }

    public static void main(String[] args) {
    	// model initialization
    	ExampleModel exampleModel = new ExampleModel();
    	
    	// controller initialization
    	ExampleController exampleController = new ExampleController(exampleModel);
    	
    	// boundary initialization
    	ExampleFunctionalKernelAdapter exampleFunctionalKernelAdapter = new ExampleFunctionalKernelAdapter(exampleController);
    	exampleModel.setBoundary(exampleFunctionalKernelAdapter);
    	ExampleDialog exampleDialog = new ExampleDialog(exampleFunctionalKernelAdapter);
    	exampleFunctionalKernelAdapter.setDialog(exampleDialog);
    	exampleDialog.initDialog();
    }

}