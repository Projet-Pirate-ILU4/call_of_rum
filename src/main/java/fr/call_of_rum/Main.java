package fr.call_of_rum;

import com.formdev.flatlaf.FlatLightLaf;
import fr.call_of_rum.boundary.ExampleBoundary;
import fr.call_of_rum.boundary.ExampleFunctionalKernelAdapter;
import fr.call_of_rum.boundary.dialog.ExampleDialog;
import fr.call_of_rum.boundary.presentation.ExamplePresentation;
import fr.call_of_rum.controller.ExampleController;
import fr.call_of_rum.model.ExampleModel;
import javax.swing.UIManager;

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
        // Look And Feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamplePresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
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
    	launchOnGUI();
    }

}