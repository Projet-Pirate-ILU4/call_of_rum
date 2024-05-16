/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author assanendoye
 */
public class Dice extends javax.swing.JPanel {
    
    private int faceValue;

    /**
     * Creates new form Dice
     */
    public Dice() {
        faceValue = 3;
    }
    
    public void setFaceValue(int value) {
        if (value >= 1 && value <= 6) {
            this.faceValue = value;
            repaint(); // Redessiner le panneau avec la nouvelle valeur de la face
        } else {
            System.out.println("La valeur du dé doit être comprise entre 1 et 6.");
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        // Calculer la taille du carré en fonction des dimensions du panneau
        int squareSize = Math.min(panelWidth, panelHeight) * 2 / 3;
        int squareX = (panelWidth - squareSize) / 2; // Position X pour centrer le carré horizontalement
        int squareY = (panelHeight - squareSize) / 2; // Position Y pour centrer le carré verticalement
        
        // Dessiner le carré
        g.setColor(Color.WHITE);
        g.fillRect(squareX, squareY, squareSize, squareSize);

        // Dessiner les points en fonction de la valeur de la face du dé
        g.setColor(Color.BLACK);
       

        int dotSize = squareSize / 6; // Taille des points en fonction de la taille du carré
        int dotOffset = dotSize * 3 / 2 ; // Espacement des points par rapport au bord du carré
        //drawDot(g, squareX + squareSize - dotOffset, squareY); // Point au milieu

        
        switch (faceValue) {
            case 1:
                drawDotCenter(g, squareX, squareY, squareSize,dotSize);
                break;
            case 2:
                drawDotTopLeft(g, squareX, squareY, squareSize,dotSize);
                drawDotBottomRight(g, squareX, squareY, squareSize,dotSize);
               
                break;
            case 3:
                drawDotTopLeft(g, squareX, squareY, squareSize,dotSize);
                drawDotCenter(g, squareX, squareY, squareSize,dotSize);
                drawDotBottomRight(g, squareX, squareY, squareSize, dotSize);
                break;
            case 4:
                
                drawDotTopLeft(g, squareX, squareY, dotOffset,dotSize);
                drawDotBottomLeft(g, squareX, squareY, squareSize,dotSize);
                drawDotBottomRight(g, squareX, squareY, squareSize,dotSize);
                drawDotTopRight(g, squareX, squareY, squareSize,dotSize);
                break;
            case 5:
                // Dessiner cinq points
                drawDotTopLeft(g, squareX, squareY, squareSize,dotSize);
                drawDotBottomLeft(g, squareX, squareY, squareSize,dotSize); // Point en bas à gauche
                drawDotCenter(g, squareX, squareY, squareSize,dotSize);
                drawDotBottomRight(g, squareX, squareY, squareSize,dotSize);
                drawDotTopRight(g, squareX, squareY, squareSize,dotSize);
                break;
            case 6:
                // Dessiner six points
                drawDotTopLeft(g, squareX, squareY, squareSize,dotSize);
                drawDotBottomLeft(g, squareX, squareY, squareSize,dotSize);
                drawDotMidLeft(g, squareX, squareY, squareSize,dotSize);
                drawDotMidRight(g, squareX, squareY, squareSize,dotSize);
                drawDotBottomRight(g, squareX, squareY, squareSize,dotSize);
                drawDotTopRight(g, squareX, squareY, squareSize,dotSize);
                break;
        }
    }

    
    private void drawDot(Graphics g, int x, int y,int size) {
        g.fillOval(x, y, size, size); // Dessiner un point
    }
    
    private void drawDotCenter(Graphics g, int x, int y,int squareSize,int dotSize){
        drawDot(g, x + squareSize / 2 - dotSize/2 , y + squareSize / 2 - dotSize/2,dotSize); // Point au milieu
    }
    
    private void drawDotTopLeft(Graphics g, int x, int y,int squareSize,int dotSize){
        drawDot(g, x + dotSize, y +dotSize,dotSize); // Point au milieu
    }
    private void drawDotTopRight(Graphics g, int x, int y,int squareSize,int dotSize){
        drawDot(g, x + squareSize - dotSize *2, y +dotSize,dotSize); // Point au milieu
    }
    
    private void drawDotBottomLeft(Graphics g, int x, int y,int squareSize,int dotSize){

        drawDot(g, x + dotSize, y + squareSize - dotSize *2,dotSize ); // Point au milieu
    }
    private void drawDotBottomRight(Graphics g, int x, int y,int squareSize,int dotSize){

        drawDot(g, x + squareSize - dotSize *2, y + squareSize - dotSize *2,dotSize ); // Point au milieu
    }
    
    private void drawDotMidLeft(Graphics g, int x, int y,int squareSize,int dotSize){
        drawDot(g, x + dotSize, y + squareSize / 2 - dotSize/2,dotSize ); // Point au milieu
    }
    
    private void drawDotMidRight(Graphics g, int x, int y,int squareSize,int dotSize){
        drawDot(g, x + squareSize - dotSize *2, y + squareSize / 2 - dotSize/2,dotSize ); // Point au milieu
    }

    public int getValue() {
        return faceValue;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dice Faces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // Taille de la fenêtre
        Dice dice = new Dice();
        frame.add(dice);
        dice.setFaceValue(3);
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
