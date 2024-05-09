/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author loferga
 */
public class IntoxicationGaugePanel extends javax.swing.JPanel {
    
    private static final Color BACKGROUND_COLOR = new Color(20, 20, 20);
    private static final Color INTOXICATION_COLOR = new Color(91, 143, 31);
    
    private float level = 0.0f;

    /**
     * Creates new form IntoxicationGaugePanel
     */
    public IntoxicationGaugePanel() {
        initComponents();
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
            .addGap(0, 15, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setLevel(float level) {
        this.level = level;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // draw Background
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, super.getWidth(), super.getHeight());
        // draw Intoxication gauge
        g.setColor(INTOXICATION_COLOR);
        g.fillRect(0, (int) ((1.0f - level) * super.getHeight()), super.getWidth(), super.getHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
