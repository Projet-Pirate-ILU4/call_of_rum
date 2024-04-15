package fr.call_of_rum.boundary;

public class ExampleBoundary implements IBoundary {

	@Override
	public void upcall() {
		System.out.println("message reçu par le modèle");
	}

}
