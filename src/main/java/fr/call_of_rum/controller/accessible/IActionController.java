package fr.call_of_rum.controller.accessible;

public interface IActionController {
	
	boolean buyItem(int itemIndex);
	
	boolean drink(int itemIndex);
	
	boolean equipWeapon(int itemIndex);
	
	boolean pickUpItem(int itemIndex);
	
	boolean dropItem(int itemIndex);
	
	boolean move();
	
}
