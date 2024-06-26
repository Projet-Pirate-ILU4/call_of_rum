/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import fr.call_of_rum.boundary.dialog.IDialog;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Solène
 */
public class CellPanel extends javax.swing.JLayeredPane {

    private CellType cellType;
    private boolean arrival=false;
    private int num;
    private ItemType[] itemDropped;
    private List<ItemDrop> droppedItems;
    private static final Random RNG = new Random();
    private IDialog dialog; 
    /**
     * Creates new form CellPanel
     */
    public CellPanel() {
        initComponents();
        this.moveToFront(itemDroppedPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numLabel = new javax.swing.JLabel();
        itemDroppedPanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMinimumSize(new java.awt.Dimension(100, 100));

        numLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        numLabel.setForeground(new java.awt.Color(255, 255, 255));
        numLabel.setText("1");
        numLabel.setAlignmentX(1.0F);
        numLabel.setAlignmentY(0.0F);
        add(numLabel);
        numLabel.setBounds(70, 10, 20, 20);

        itemDroppedPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        itemDroppedPanel.setOpaque(false);

        javax.swing.GroupLayout itemDroppedPanelLayout = new javax.swing.GroupLayout(itemDroppedPanel);
        itemDroppedPanel.setLayout(itemDroppedPanelLayout);
        itemDroppedPanelLayout.setHorizontalGroup(
            itemDroppedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        itemDroppedPanelLayout.setVerticalGroup(
            itemDroppedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(itemDroppedPanel);
        itemDroppedPanel.setBounds(0, 0, 100, 100);

        imageLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        add(imageLabel);
        imageLabel.setBounds(0, 0, 100, 100);
    }// </editor-fold>//GEN-END:initComponents

    public void setNum(int num){
        this.num=num;
        numLabel.setText(String.valueOf(num));
    }
    
    public int getNum(){
        return num;
    }
    
    public void setType(CellType type){
        cellType=type;
        putImage();
    }
    
    public void setNumColor(Color color){
        numLabel.setForeground(color);
    }

    public void putImage(){
        BufferedImage typeImage = ImageLoader.loadImage("presentation/cell/"+cellType.toString().toLowerCase()+".png");
        Image scaledTypeImage;
        if (cellType.toString().toLowerCase().equals("shortcut")){
            scaledTypeImage = typeImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            imageLabel.setLocation(20, 10);
        }else{
            scaledTypeImage = typeImage.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            imageLabel.setLocation(20, 10);
        }
        ImageIcon typeIcon = new ImageIcon(scaledTypeImage);
        imageLabel.setIcon(typeIcon);
    }
    
    /**
     * Add component in a random location in container
     * @author Mateo LAFORGE
     * @param container Container in which to add the component
     * @param component JComponent to add to container
     */
    public void addComponentRandom(Container container, JComponent component) {
        Dimension componentDimension = component.getPreferredSize();
        int componentWidth = componentDimension.width;
        int componentHeight = componentDimension.height;
        int containerWidth = container.getWidth();
        int containerHeight = container.getHeight();
        
        int minx = componentWidth;
        int miny = componentHeight;
        int maxx = containerWidth - componentWidth;
        int maxy = containerHeight - componentHeight;
        
        int x = RNG.nextInt(minx, maxx);
        int y = RNG.nextInt(miny, maxy);
        
        component.setBounds(x, y, componentWidth, componentHeight);
        
        container.add(component);
        container.revalidate();
        container.repaint();
    }
    
    // ajoute tout les ItemDrop à la case (attention, ajout sans vérification de duplicat)
    private void addAllItemDrop() {
        ItemType[] droppedItems = dialog.getDroppedItems(this.num-1);
        for (int i = 0; i<droppedItems.length; i++) {
            addComponentRandom(this.itemDroppedPanel, new ItemDrop(dialog, droppedItems[i], i, this));
        }
    }

    // apellée au moment de la construction
    public void initDroppedItems(IDialog dialog) {
        this.dialog = dialog;
        addAllItemDrop();
    }

    // apellée au moment où un drop intervient (par l'inventaire)
    public void notifyDrop(ItemType item) {
        int numberOfDroppedItems = dialog.getNumberOfDroppedItems(this.num);
        // numberOfDroppedItems ici est l'indice du nouvel objet
        addComponentRandom(this.itemDroppedPanel, new ItemDrop(dialog, item, numberOfDroppedItems, this));
    }

    // apellée au moment où un pick up intervient (par un ItemDrop)
    public void pickUpItem(int index) {
        // update presque-innévitable, donc on vas préférer tout reconstruire
        // destruction des ItemDrop précédents:
        this.itemDroppedPanel.removeAll();
        this.moveToFront(itemDroppedPanel);
        dialog.pickUpItem(index);
        addAllItemDrop();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel itemDroppedPanel;
    private javax.swing.JLabel numLabel;
    // End of variables declaration//GEN-END:variables
}
