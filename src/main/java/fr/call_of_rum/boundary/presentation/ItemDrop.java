/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import fr.call_of_rum.boundary.dialog.IDialog;
import fr.call_of_rum.util.ItemType;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Solène
 */
public class ItemDrop extends javax.swing.JPanel {

    private IDialog dialog;
    private int index;
    private ItemType itemType;
    private CellPanel position;
    private int posX;
    private int posY;
    
    
    public void setIndex(int index){
        this.index=index;
    }
    
    public int getIndex(){
        return index;
    }
    /**
     * Creates new form DropItem
     */
    public ItemDrop(IDialog dialog, ItemType itemType, int index, CellPanel position) {
        initComponents();
        this.itemType=itemType;
        this.index=index;
        this.dialog=dialog;
        this.position=position;
        BufferedImage typeImage = ImageLoader.loadImage("presentation/"+itemType.toString().toLowerCase()+".png");
        Image scaledTypeImage;
        scaledTypeImage = typeImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon typeIcon = new ImageIcon(scaledTypeImage);
        imageLabel.setIcon(typeIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(25, 25));
        setOpaque(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        imageLabel.setMinimumSize(new java.awt.Dimension(25, 25));
        imageLabel.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int depX = evt.getX() - posX;
        int depY = evt.getY() - posY;
        int newX=getX()+depX;
        int newY=getY()+depY;
        if ((newX>(position.getWidth()))
                    ||(newY<0)
                    ||(newX<0)
                    ||(newY>position.getHeight())){
                this.setLocation(posX, posY);
            }else{
                this.setLocation(newX, newY);
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        position.pickUpItem(index);
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        posX=evt.getX();
        posY=evt.getY();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    // End of variables declaration//GEN-END:variables
}
