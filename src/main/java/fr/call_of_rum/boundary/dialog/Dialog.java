package fr.call_of_rum.boundary.dialog;

import java.awt.EventQueue;

import fr.call_of_rum.boundary.IFunctionalKernel;
import fr.call_of_rum.boundary.IGraphicInterface;
import fr.call_of_rum.boundary.presentation.GameFrame;
import fr.call_of_rum.util.CellType;

public class Dialog implements IDialog, IGraphicInterface {
	
	private GameFrame presentation;
	private IFunctionalKernel functionalKernelAdapter;
	
	public Dialog(IFunctionalKernel functionalKernelAdapter) {
		this.presentation = new GameFrame(this);
		this.functionalKernelAdapter = functionalKernelAdapter;
	}
	
	public void initDialog() {
		EventQueue.invokeLater(() -> this.presentation.setVisible(true));
	}

	@Override
	public CellType askCellType(int numCell) {
		return functionalKernelAdapter.askCellType(numCell);
	}

	@Override
	public void showMessage(String msg) {
		presentation.showMessage(msg);
	}
	
	@Override
	public void close() {
		presentation.dispose();
	}

}
