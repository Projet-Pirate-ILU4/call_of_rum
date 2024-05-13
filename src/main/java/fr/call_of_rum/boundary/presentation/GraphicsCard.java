/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import fr.call_of_rum.util.ItemType;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author wil-mcjohnley
 */
public class GraphicsCard extends javax.swing.JPanel {
    private ItemType imageName;

    /**
     * Creates new form GraphicsCard
     */
    public GraphicsCard() {
        initComponents();
    }
    
    public void setImage(ItemType imageName, int price, String name , String description){
        this.imageName=imageName;
        designImage(price,name,description);
    }
    
    private void designImage(int value, String nameValue, String descriptionValue){
        System.out.println(imageName.toString());
        BufferedImage image = ImageLoader.loadImage("presentation/"+imageName.toString().toLowerCase()+".png");
        Image scaledTypeImage;
        scaledTypeImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        imageContainer.setLocation(0, getWidth()/2);
        price.setText(""+value);
        nameLabel.setText(nameValue);
        description.setText(descriptionValue);
        
        ImageIcon typeIcon = new ImageIcon(scaledTypeImage);
        imageContainer.setIcon(typeIcon);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageContainer = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        description = new javax.swing.JLabel();

        nameLabel.setText("0");

        price.setText("jLabel1");

        description.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description)
                    .addComponent(price)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(nameLabel)))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(0, 0, 0)
                        .addComponent(price)))
                .addGap(0, 0, 0)
                .addComponent(description)
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel description;
    private javax.swing.JLabel imageContainer;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}