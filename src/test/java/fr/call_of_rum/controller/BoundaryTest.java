package fr.call_of_rum.controller;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.controller.accessible.*;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

import java.util.Optional;

public class BoundaryTest implements IBoundary {
    @Override
    public void subscribeActionController(IActionController actionController) {
        
    }

    @Override
    public void subscribeBoardController(IBoardController boardController) {

    }

    @Override
    public void subscribeDiceController(IDiceController diceController) {

    }

    @Override
    public void subscribeMarketController(IMarketController marketController) {

    }

    @Override
    public void subscribePlayerController(IPlayerController playerController) {

    }

    @Override
    public void giveTurn(Player player) {

    }

    @Override
    public void stepOnBomb() {
        System.out.println("BOMMMMMMM !!!!! je suis sur une bombe");

    }

    @Override
    public void tookShortcut() {
        System.out.println("Raccourcie !!!!! j'ai pris un raccourcie");
    }

    @Override
    public boolean chestFound(int coinAmount, ItemType itemNamespace) {
        return false;
    }

    @Override
    public boolean openedChestFound(int coinAmount, Optional<ItemType> itemNamespace) {
        return false;
    }

    @Override
    public void duel(Player winner) {
        System.out.println("C'est l'heure du DU DU DUEL !!!!");
        System.out.println(winner.toString() + " a gagner le duel");
    }

    @Override
    public void gameEnded(Player winner) {
        System.out.println("C'est la fin du jeu ");
        System.out.println(winner.toString() + " a gagner la partie");
    }
}
