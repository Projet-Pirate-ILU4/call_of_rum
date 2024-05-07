package fr.call_of_rum.boundary;

public class FunctionalKernelAdapter implements IBoundary, IFunctionalKernel {
	
	private IGraphicInterface graphicInterface;
	
	public void setGraphicInterface(IGraphicInterface graphicInterface) {
		this.graphicInterface = graphicInterface;
	}

	@Override
	public void gameEnded(int winner) {
	}

}
