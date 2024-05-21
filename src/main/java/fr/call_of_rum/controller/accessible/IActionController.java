package fr.call_of_rum.controller.accessible;

public interface IActionController {
	
	void buyItem(int itemIndex);
	
	void drink(int itemIndex);
	
	void equipWeapon(int itemIndex);
	
	void pickUpItem(int itemIndex);
	
	void dropItem(int itemIndex);
	
	void move();
	
}
