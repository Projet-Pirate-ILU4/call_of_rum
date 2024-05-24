package fr.call_of_rum.boundary.presentation;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import fr.call_of_rum.boundary.dialog.IDialog;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InventoryPanel extends javax.swing.JPanel {

    private IDialog dialog;

    private boolean activate = true;

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    private ItemType[] inventory = {null,null,null};
    private JLabel[] imageLabels = new JLabel[3];

    public InventoryPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(200, 32767));
        setPreferredSize(new java.awt.Dimension(208, 131));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel1.setText("Inventaire : ");

        // Initialize image labels
        imageLabels[0] = new JLabel();
        imageLabels[1] = new JLabel();
        imageLabels[2] = new JLabel();

        jPanel1.add(imageLabels[0]);
        jPanel2.add(imageLabels[1]);
        jPanel3.add(imageLabels[2]);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabels[0], javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabels[0], javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        imageLabels[0].setOpaque(true);
        imageLabels[1].setOpaque(true);
        imageLabels[2].setOpaque(true);
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabels[1], javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabels[1], javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabels[2], javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabels[2], javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void setDialog(IDialog dialog) {
        this.dialog = dialog;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setInventory(ItemType item) {
        for (int position = 0; position < inventory.length; position++) {
            if (inventory[position] == null) {
                inventory[position] = item;
                updateImage(position);
                break;
            }
        }
    }

    

    private void updateImage(int position) {
        if (inventory[position] != null) {
            BufferedImage image = ImageLoader.loadImage("presentation/"+inventory[position].toString().toLowerCase()+".png");
            Image scaledTypeImage;
            scaledTypeImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon typeIcon = new ImageIcon(scaledTypeImage);
            imageLabels[position].setIcon(typeIcon);
        } else {
            imageLabels[position].setIcon(null);
        }
    }

    public void removeItem(ItemType itemType) {
        for (int i =  inventory.length -1; i >= 0; i--) {
            if  (inventory[i] != null && inventory[i].equals(itemType)) {
                inventory[i] = null;
                updateImage(i);
                return;
            }
        }
    }

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if (isActivate() && inventory[0] != null) {
            int itemIndex = inventory[0].ordinal();
            popUpItem(itemIndex,0);
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        if (isActivate() && inventory[1] != null) {
            int itemIndex = inventory[1].ordinal();
            popUpItem(itemIndex,1);
        }
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        if (isActivate() && inventory[2] != null) {
            int itemIndex = inventory[2].ordinal();
            popUpItem(itemIndex,2);
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    void popUpItem(int itemIndex, int inventoryIndex){
        String message = "";
           
            message += "Que voulez-vous faire avec cet objet ?";
            Object[] options = {"Utiliser", "Jeter", "Examiner", "Ne rien Faire"};
            int choice = JOptionPane.showOptionDialog(null, message, "Actions sur l'objet", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
            switch (choice) {
                case JOptionPane.YES_OPTION:
                	ItemType item = inventory[inventoryIndex];
                	boolean succeded = false;
                	if (dialog.isLiquid(item)) {
                		succeded = dialog.drink(player, inventoryIndex);
                	} else if (dialog.isWeapon(item)) {
                		succeded = dialog.equip(player, inventoryIndex);
            		}
                	if (succeded) {
                		inventory[inventoryIndex] = null;
                		updateImage(inventoryIndex);
                		System.out.println("L'objet a été utilisé");
                	} else {
                		System.out.println("L'objet n'as pas été utilisé");
                	}
                    break;
                case JOptionPane.NO_OPTION:
                	dialog.dropItem(player, inventoryIndex);
                	inventory[inventoryIndex] = null;
                	updateImage(inventoryIndex);
                    System.out.println("L'objet a été jeté");
                    break;
                case JOptionPane.CANCEL_OPTION:
                	String description = dialog.getItemDescription(inventory[inventoryIndex]);
                    JOptionPane.showMessageDialog(null, description, "Description de l'objet", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Vous examinez l'objet");
                    break;
                case 3:
                    System.out.println("Aucune action n'a été effectuée sur l'objet");
                    break;
            }
    }

    private Player player;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;

    public void setInventories(ItemType[] inventory) {
        for (ItemType itemType : inventory) {
            setInventory(itemType);
        }
    }
}
