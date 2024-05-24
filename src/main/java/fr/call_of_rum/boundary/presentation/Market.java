/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;


import fr.call_of_rum.boundary.dialog.DialogStub;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import fr.call_of_rum.boundary.dialog.IDialog;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

/**
 *
 * @author assanendoye
 */
public class Market extends javax.swing.JDialog {

    /**
     * Creates new form Market
     */
    public Market(Frame parent,boolean modal ,Player player, IDialog dialog) {
        super(parent,modal);
        this.player = player;
        this.dialog = dialog;
        focus = new HashMap<>();
        this.size = dialog.getNumberOfFreeSlots();
        itemsSelected = new ArrayList<>();
        score = dialog.checkfunds(player);
        itemTypes = dialog.getMarketItems();

        initComponents();

        focus.put(graphicsCard1, false);
        focus.put(graphicsCard2, false);
        focus.put(graphicsCard3, false);
        focus.put(graphicsCard4, false);
        
        graphicsCardsIndex = new HashMap<>();
        graphicsCardsIndex.put(graphicsCard1, 0);
        graphicsCardsIndex.put(graphicsCard2, 1);
        graphicsCardsIndex.put(graphicsCard3, 2);
        graphicsCardsIndex.put(graphicsCard4, 3);
        
        graphicsCard4.setDialog(dialog);
        graphicsCard3.setDialog(dialog);
        graphicsCard2.setDialog(dialog);
        graphicsCard1.setDialog(dialog);
        
        graphicsCard1.setImage(itemTypes[0]);
        graphicsCard2.setImage(itemTypes[1]);
        graphicsCard3.setImage(itemTypes[2]);
        graphicsCard4.setImage(itemTypes[3]);

        inventoryPanel1.setDialog(dialog);
        inventoryPanel1.setActivate(false);
        updateMarket();
        inventoryPanel1.setInventories(dialog.getInventory(player));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        coinScorePanel1 = new fr.call_of_rum.boundary.presentation.CoinScorePanel();
        graphicsCard2 = new fr.call_of_rum.boundary.presentation.GraphicsCard();
        graphicsCard3 = new fr.call_of_rum.boundary.presentation.GraphicsCard();
        graphicsCard4 = new fr.call_of_rum.boundary.presentation.GraphicsCard();
        graphicsCard1 = new fr.call_of_rum.boundary.presentation.GraphicsCard();
        inventoryPanel1 = new fr.call_of_rum.boundary.presentation.InventoryPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Market`");
        setPreferredSize(new java.awt.Dimension(620, 650));
        setSize(new java.awt.Dimension(620, 650));
        getContentPane().setLayout(null);

        jButton1.setText("Valider");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 520, 162, 51);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/market.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 30, 100, 100);

        jLabel2.setText("Market");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 30, 37, 16);

        jLabel3.setText("Bienvenue dans le marché");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 160, 138, 25);

        coinScorePanel1.setOpaque(false);
        getContentPane().add(coinScorePanel1);
        coinScorePanel1.setBounds(480, 0, 103, 55);

        graphicsCard2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        graphicsCard2.setEnabled(false);
        graphicsCard2.setOpaque(false);
        graphicsCard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graphicsCard2MouseClicked(evt);
            }
        });
        getContentPane().add(graphicsCard2);
        graphicsCard2.setBounds(310, 230, 220, 120);

        graphicsCard3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        graphicsCard3.setMinimumSize(new java.awt.Dimension(400, 400));
        graphicsCard3.setOpaque(false);
        graphicsCard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graphicsCard3MouseClicked(evt);
            }
        });
        getContentPane().add(graphicsCard3);
        graphicsCard3.setBounds(310, 360, 220, 120);

        graphicsCard4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        graphicsCard4.setOpaque(false);
        graphicsCard4.setPreferredSize(new java.awt.Dimension(400, 400));
        graphicsCard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graphicsCard4MouseClicked(evt);
            }
        });
        getContentPane().add(graphicsCard4);
        graphicsCard4.setBounds(90, 360, 210, 120);

        graphicsCard1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        graphicsCard1.setEnabled(false);
        graphicsCard1.setOpaque(false);
        graphicsCard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graphicsCard1MouseClicked(evt);
            }
        });
        getContentPane().add(graphicsCard1);
        graphicsCard1.setBounds(90, 230, 210, 120);

        inventoryPanel1.setOpaque(false);
        getContentPane().add(inventoryPanel1);
        inventoryPanel1.setBounds(320, 100, 233, 92);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/background_market3.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 620, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        valider();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        valider();
    }//GEN-LAST:event_jButton1MouseClicked


    private void graphicsCard3MouseClicked(MouseEvent evt) {//GEN-FIRST:event_graphicsCard3MouseClicked
        toogle(graphicsCard3);

    }//GEN-LAST:event_graphicsCard3MouseClicked

    private void graphicsCard2MouseClicked(MouseEvent evt) {//GEN-FIRST:event_graphicsCard2MouseClicked
        toogle(graphicsCard2);
    }//GEN-LAST:event_graphicsCard2MouseClicked

    private void graphicsCard4MouseClicked(MouseEvent evt) {//GEN-FIRST:event_graphicsCard4MouseClicked
        toogle(graphicsCard4);
    }//GEN-LAST:event_graphicsCard4MouseClicked

    private void graphicsCard1MouseClicked(MouseEvent evt) {
        toogle(graphicsCard1);
    }                                          
    
    private void focusItem(GraphicsCard graphicsCard){
        int prix = dialog.getPrice(graphicsCardsIndex.get(graphicsCard));
        graphicsCard.setEnabled(false);
        if (score > prix && size >0) {
            graphicsCard.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            size--;
            System.out.println(score);
            score = score - prix;
            System.out.println(score);
            itemsSelected.add(graphicsCardsIndex.get(graphicsCard));
            focus.put(graphicsCard,!focus.get(graphicsCard));
            updateMarket();
            inventoryPanel1.setInventory(graphicsCard.getItemType());
        }
    }

    private void unFocusitem(GraphicsCard graphicsCard){
        graphicsCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size ++;
        score += dialog.getPrice(graphicsCardsIndex.get(graphicsCard));
        itemsSelected.remove(graphicsCardsIndex.get(graphicsCard));
        focus.put(graphicsCard,!focus.get(graphicsCard));
        inventoryPanel1.removeItem(graphicsCard.getItemType());
        updateMarket();
    }




    private void updateMarket() {
        coinScorePanel1.setScore(score);
        // Vérifier chaque carte
        for (Map.Entry<GraphicsCard, Boolean> entry : focus.entrySet()) {
            GraphicsCard card = entry.getKey();
            boolean isFocused = entry.getValue();

            // Si la carte est déjà focus, passer à la suivante
            if (isFocused) {
                continue;
            }

            // Si la carte est désactivée et le score est inférieur au prix de la carte et la taille de l'inventaire est vide, l'activer
            if (!card.isEnabled() && (score < dialog.getPrice(graphicsCardsIndex.get(card)) && size == 0)) {
                card.setEnabled(true);
            }
            // Sinon, si la carte est activée et le score est supérieur ou égal au prix de la carte et la taille de l'inventaire n'est pas vide, la désactiver
            else if (card.isEnabled() && (score >= dialog.getPrice(graphicsCardsIndex.get(card)) ||  size > 0)) {
                card.setEnabled(false);
            }
        }
    }

    private void valider() {
        if (!itemsSelected.isEmpty()) {
        	itemsSelected.forEach(i -> dialog.buy(i));
            dialog.print(player.toString() + " a acheté :");
            for (Map.Entry<GraphicsCard, Boolean> entry : focus.entrySet()) {
                GraphicsCard card = entry.getKey();
                boolean isFocused = entry.getValue();
                if (isFocused) {
                    dialog.print(card.getItemType() + " pour " + dialog.getPrice(graphicsCardsIndex.get(card)) + " $");
                }
            }
        } else {
            dialog.print(player.toString() + " n'a rien acheté.");
        }
        dispose();
        System.out.println(itemsSelected);
    }


    public void toogle(GraphicsCard graphicsCard) {
        if (focus.get(graphicsCard)) {
            unFocusitem(graphicsCard);
        } else if (score < dialog.getPrice(graphicsCardsIndex.get(graphicsCard)) && size == 0) {
            focusItem(graphicsCard);
        }
        System.out.println("\nContenu de la HashMap :");
        for (Map.Entry<GraphicsCard, Boolean> focus : focus.entrySet()) {
            System.out.println(focus.getKey().getItemType() + " : " + focus.getValue());
        }
    }


    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Market.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> new Market(new JFrame(),true, Player.JACK_LE_BORGNE, new DialogStub()).setVisible(true));
    }


    private final HashMap<GraphicsCard,Boolean> focus;
    private final Player player;
    private final IDialog dialog;
    private final ItemType[] itemTypes;
    private final List<Integer> itemsSelected;
    private HashMap<GraphicsCard, Integer> graphicsCardsIndex;
    private int score ;
    private int size;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fr.call_of_rum.boundary.presentation.CoinScorePanel coinScorePanel1;
    private fr.call_of_rum.boundary.presentation.GraphicsCard graphicsCard1;
    private fr.call_of_rum.boundary.presentation.GraphicsCard graphicsCard2;
    private fr.call_of_rum.boundary.presentation.GraphicsCard graphicsCard3;
    private fr.call_of_rum.boundary.presentation.GraphicsCard graphicsCard4;
    private fr.call_of_rum.boundary.presentation.InventoryPanel inventoryPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables



}
