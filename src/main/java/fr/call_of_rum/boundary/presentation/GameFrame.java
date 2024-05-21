/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import fr.call_of_rum.boundary.dialog.IDialog;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

import java.util.List;

import static fr.call_of_rum.util.ItemType.*;
import static fr.call_of_rum.util.ItemType.LICIDITY_STONE;

/**
 *
 * @author loferga
 */
public class GameFrame extends javax.swing.JFrame {
	
	private IDialog dialog;
	
    /**
     * Creates new form GameFrame
     * @param dialog
     */
    public GameFrame(IDialog dialog) {
    	this.dialog = dialog;
    	try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        endTurnSecondPlayer = new javax.swing.JButton();
        playerPanel2 = new fr.call_of_rum.boundary.presentation.PlayerPanel();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        endTurnFirstPlayer = new javax.swing.JButton();
        playerPanel3 = new fr.call_of_rum.boundary.presentation.PlayerPanel();
        jPanel4 = new javax.swing.JPanel();
        boardPanel1 = new fr.call_of_rum.boundary.presentation.BoardPanel();
        boardPanel1.setCellsType(dialog.getCellsType());
        boardPanel1.initCells(dialog);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        dicePanel1 = new fr.call_of_rum.boundary.presentation.DicePanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        endTurnSecondPlayer.setText("End Turn");
        endTurnSecondPlayer.setEnabled(false);
        endTurnSecondPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnSecondPlayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playerPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(endTurnSecondPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(endTurnSecondPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jSplitPane1.setRightComponent(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel2);

        endTurnFirstPlayer.setText("End Turn");
        endTurnFirstPlayer.setEnabled(false);
        endTurnFirstPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnFirstPlayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(playerPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(endTurnFirstPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(endTurnFirstPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jSplitPane2.setLeftComponent(jPanel3);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/market.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dicePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(boardPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dicePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanel4);

        jSplitPane1.setLeftComponent(jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void endTurnFirstPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnFirstPlayerActionPerformed
        synchronized (this) {
            dialog.endTurn();
            this.notifyAll();
        }
        endTurnFirstPlayer.setEnabled(false);
    }//GEN-LAST:event_endTurnFirstPlayerActionPerformed

    private void endTurnSecondPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnSecondPlayerActionPerformed
        synchronized (this) {
            dialog.endTurn();
            this.notifyAll();
        }
        endTurnSecondPlayer.setEnabled(false);
    }//GEN-LAST:event_endTurnSecondPlayerActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        java.awt.EventQueue.invokeLater(() -> new Market(this,true, Player.JACK_LE_BORGNE, dialog).setVisible(true));
    }//GEN-LAST:event_jLabel1MouseClicked
    
    public void enableFirstPlayer() {
        endTurnFirstPlayer.setEnabled(true);
    }
    
    public void enableSecondPlayer() {
    	endTurnSecondPlayer.setEnabled(true);
    }
    
	public void printMessage(String msg) {
		// TODO implements
	}
	
	public void clearMessages() {
		// TODO implements
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GameFrame(new IDialog() {
				@Override
				public CellType[] getCellsType() {
					CellType[] cellsType = new CellType[30];
                                        for (int i = 0; i < 30; i++) {
                                            cellsType[i] = CellType.NORMAL;
                                        }
                                        return cellsType;
				}
				@Override
				public void endTurn() {
				}
				@Override
                public int getPrice(ItemType itemType) {
                    return 75;
                }
				@Override
				public int getSizeInventaireAvailable(Player player) {
					// TODO Auto-generated method stub
					return 4;
				}
				@Override
                public int checkfound(Player player) {
                    return 1000;
                }
				@Override
                public ItemType[] getItemMarket() {
                    ItemType[] itemTypes = new ItemType[4];
                    itemTypes[0] = CLOVER;
                    itemTypes[1] = BANDANA;
                    itemTypes[2] = GUNPOWDER;
                    itemTypes[3] = LICIDITY_STONE;
                    return  itemTypes;
                }

                @Override
                public void buy(Player player, List<ItemType> itemTypesSelect) {

                }

                @Override
                public String getNameItem(ItemType itemType) {
                    return  itemType.toString();
                }
                @Override
                public String getDescribe(ItemType itemType) {
                    return "Lorem ipsum dolor sit amet, consectetur adipiscing elit,";
                }

                @Override
                public void useItem(int itemIndex) {

                }

                @Override
                public void throwItem(int itemIndex) {

                }

                @Override
                public String getDescribe2(int itemIndex) {
                    return null;
                }

                @Override
                public void print(String s) {

                }
                
                @Override
                public ItemType[] getDroppedItems(int cellIndex){
                    ItemType[] itemTypes = new ItemType[0];
                    return itemTypes;
                }
        
                @Override
                public int getNumberOfDroppedItems(int cellIndex){
                    return -1;
                }

            }).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fr.call_of_rum.boundary.presentation.BoardPanel boardPanel1;
    private fr.call_of_rum.boundary.presentation.DicePanel dicePanel1;
    private javax.swing.JButton endTurnFirstPlayer;
    private javax.swing.JButton endTurnSecondPlayer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextArea jTextArea1;
    private fr.call_of_rum.boundary.presentation.PlayerPanel playerPanel2;
    private fr.call_of_rum.boundary.presentation.PlayerPanel playerPanel3;
    // End of variables declaration//GEN-END:variables
}
