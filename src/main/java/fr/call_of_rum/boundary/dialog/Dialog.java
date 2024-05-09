package fr.call_of_rum.boundary.dialog;

import java.awt.EventQueue;
import java.util.Optional;

import fr.call_of_rum.boundary.IFunctionalKernel;
import fr.call_of_rum.boundary.IGraphicInterface;
import fr.call_of_rum.boundary.presentation.GameFrame;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.Player;

public class Dialog implements IDialog, IGraphicInterface {
	
	private GameFrame presentation;
	private IFunctionalKernel functionalKernelAdapter;
	
	public Dialog(IFunctionalKernel functionalKernelAdapter) {
		this.functionalKernelAdapter = functionalKernelAdapter;
		this.presentation = new GameFrame(this);
	}
	
	public void initDialog() {
		EventQueue.invokeLater(() -> this.presentation.setVisible(true));
	}

	@Override
	public CellType askCellType(int numCell) {
		return functionalKernelAdapter.askCellType(numCell);
	}
	
	private boolean isTurnEnded;

	@Override
	public void giveTurn(Player player) {
		if (player == Player.JACK_LE_BORGNE) {
			presentation.enableFirstPlayer();
		} else {
			presentation.enableSecondPlayer();
		}
		isTurnEnded = false;
		synchronized (presentation) {
			while (!isTurnEnded) {
                try {
                    presentation.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    // Handle interruption
                }
            }
		}
	}
	
	public void endTurn() {
		isTurnEnded = true;
	}
	
	@Override
	public void showChest(int coinAmount, String itemNamespace) {
		// TODO implements
	}

	@Override
	public void showOpenedChest(int coinAmount, Optional<String> itemNamespace) {
		// TODO implements
		
	}
	
	@Override
	public void showExplosion() {
		// TODO implements
	}

	@Override
	public void showShortcut() {
		// TODO implements
	}
	
	@Override
	public void printMessage(String msg) {
		presentation.printMessage(msg);
	}
	
	@Override
	public void clearMessages() {
		presentation.clearMessages();
	}
	
	@Override
	public void close() {
		presentation.dispose();
	}

}
