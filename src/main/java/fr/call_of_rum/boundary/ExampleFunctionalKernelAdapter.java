package fr.call_of_rum.boundary;

import fr.call_of_rum.boundary.dialog.ExampleDialog;
import fr.call_of_rum.controller.IDownCall;

public class ExampleFunctionalKernelAdapter implements IBoundary, IFunctionalKernel {
	
	private ExampleDialog dialog;
	private IDownCall downcallController;
	// and every controller needed to implements IFunctionalKernel
	
	public void setDialog(ExampleDialog dialog) {
		this.dialog = dialog;
	}
	
	public void setDownCallController(IDownCall downcallController) {
		this.downcallController = downcallController;
	}
	
	@Override
	public void downcall() {
		downcallController.downcall();
	}

	@Override
	public void upcall() {
		dialog.upcall();
	}

}
