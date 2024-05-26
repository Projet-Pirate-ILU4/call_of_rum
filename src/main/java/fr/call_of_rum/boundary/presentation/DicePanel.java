/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

import fr.call_of_rum.boundary.dialog.DialogStub;
import fr.call_of_rum.boundary.dialog.IDialog;

/**
 *
 * @author assanendoye
 */
public class DicePanel extends javax.swing.JPanel {

    /**
     * Creates new form DicePanel
     */

    private int valueFace1;
    private int valueFace2;

    private IDialog dialog;

    public void setDialog(IDialog dialog) {
        this.dialog = dialog;
    }

    public DicePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dice1 = new fr.call_of_rum.boundary.presentation.Dice();
        dice2 = new fr.call_of_rum.boundary.presentation.Dice();
        throwDicesButton = new javax.swing.JButton();

        javax.swing.GroupLayout dice1Layout = new javax.swing.GroupLayout(dice1);
        dice1.setLayout(dice1Layout);
        dice1Layout.setHorizontalGroup(
            dice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        dice1Layout.setVerticalGroup(
            dice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dice2Layout = new javax.swing.GroupLayout(dice2);
        dice2.setLayout(dice2Layout);
        dice2Layout.setHorizontalGroup(
            dice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        dice2Layout.setVerticalGroup(
            dice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        throwDicesButton.setText("Lancer dès");
        throwDicesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                throwDicesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(dice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(throwDicesButton)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(throwDicesButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void throwDicesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_throwDicesButtonActionPerformed
        throwDices();
        dialog.notifyDicesThrown(true);
    }//GEN-LAST:event_throwDicesButtonActionPerformed
    
    public static int generateRandomNumber() {
        return RNG.nextInt(6) + 1; // Génère un nombre entre 0 et 5, on ajoute 1 pour obtenir un nombre entre 1 et 6
    }
    
    private static final Random RNG = new Random();
    
    public void throwDices(){
        throwDicesButton.setEnabled(false);
        valueFace1 = dialog.getFirstDiceResult();
        valueFace2 = dialog.getSecondDiceResult();
        timer.start();
    }
    
    private final Timer timer = new Timer(100, e -> 
        setRandomFace()
    );

    private int dicesRolledCount = 0;
    
    private void setRandomFace() {
    	dicesRolledCount++;
        if (dicesRolledCount > 6) {
            dice1.setFaceValue(valueFace1);
            dice2.setFaceValue(valueFace2);
            timer.stop();
            dicesRolledCount = 0;
        } else {
            dice1.setFaceValue(generateRandomNumber());
            dice2.setFaceValue(generateRandomNumber());
        }
    }

    public void setThrowButton(boolean bool) {
        throwDicesButton.setEnabled(bool);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dice Faces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Taille de la fenêtre
        DicePanel dicePanel = new DicePanel();
        frame.add(dicePanel);
        dicePanel.setDialog(new DialogStub());
        frame.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fr.call_of_rum.boundary.presentation.Dice dice1;
    private fr.call_of_rum.boundary.presentation.Dice dice2;
    private javax.swing.JButton throwDicesButton;
    // End of variables declaration//GEN-END:variables
}
