/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JLayeredPane.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.Player;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Solène
 */
public class BoardPanel extends javax.swing.JLayeredPane {
    
    private CellPanel[] cellsPanel;
    private boolean isToken1Movable = true;
    private boolean isToken2Movable = false;
    /*private boolean isToken1Clicked = false;
    //private boolean isToken2Clicked = false;
    
    public void setToken1AsClicked() {
        isToken1Clicked = true;
    }
    
    public void setToken2AsClicked() {
        isToken2Clicked = true;
    }*/
    public void setToken1asMovable() {
        isToken1Movable = true;
    }
    
    public void setToken2asMovable() {
        isToken2Movable = true;
    }
    
    public boolean getisToken1Movable() {
        return isToken1Movable;
    }
    
    public boolean getisToken2Movable() {
        return isToken2Movable;
    }
    /**
     * Creates new form BoardPanel
     */
    public BoardPanel() {
        initComponents();
        BufferedImage typeImage = ImageLoader.loadImage("presentation/background.png");
        Image scaledTypeImage = typeImage.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        ImageIcon typeIcon = new ImageIcon(scaledTypeImage);
        backgroundLabel.setIcon(typeIcon);
        cellsPanel=new CellPanel[30];
        cellsPanel[0]=cellPanel1;
        cellsPanel[1]=cellPanel2;
        cellsPanel[2]=cellPanel3;
        cellsPanel[3]=cellPanel4;
        cellsPanel[4]=cellPanel5;
        cellsPanel[5]=cellPanel6;
        cellsPanel[6]=cellPanel7;
        cellsPanel[7]=cellPanel8;
        cellsPanel[8]=cellPanel9;
        cellsPanel[9]=cellPanel10;
        cellsPanel[10]=cellPanel11;
        cellsPanel[11]=cellPanel12;
        cellsPanel[12]=cellPanel13;
        cellsPanel[13]=cellPanel14;
        cellsPanel[14]=cellPanel15;
        cellsPanel[15]=cellPanel16;
        cellsPanel[16]=cellPanel17;
        cellsPanel[17]=cellPanel18;
        cellsPanel[18]=cellPanel19;
        cellsPanel[19]=cellPanel20;
        cellsPanel[20]=cellPanel21;
        cellsPanel[21]=cellPanel22;
        cellsPanel[22]=cellPanel23;
        cellsPanel[23]=cellPanel24;
        cellsPanel[24]=cellPanel25;
        cellsPanel[25]=cellPanel26;
        cellsPanel[26]=cellPanel27;
        cellsPanel[27]=cellPanel28;
        cellsPanel[28]=cellPanel29;
        cellsPanel[29]=cellPanel30;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cellPanel1 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel1.setNum(1);
        cellPanel2 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel2.setNum(2);
        cellPanel3 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel3.setNum(3);
        cellPanel4 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel4.setNum(4);
        cellPanel5 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel5.setNum(5);
        cellPanel6 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel6.setNum(6);
        cellPanel30 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel30.setNum(30);
        cellPanel23 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel23.setNum(23);
        cellPanel22 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel22.setNum(22);
        cellPanel15 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel15.setNum(15);
        cellPanel14 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel14.setNum(14);
        cellPanel7 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel7.setNum(7);
        cellPanel29 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel29.setNum(29);
        cellPanel24 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel24.setNum(24);
        cellPanel21 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel21.setNum(21);
        cellPanel16 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel16.setNum(16);
        cellPanel13 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel13.setNum(13);
        cellPanel8 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel8.setNum(8);
        cellPanel28 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel28.setNum(28);
        cellPanel25 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel25.setNum(25);
        cellPanel20 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel20.setNum(20);
        cellPanel17 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel17.setNum(17);
        cellPanel12 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel12.setNum(12);
        cellPanel9 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel9.setNum(9);
        cellPanel27 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel27.setNum(27);
        cellPanel26 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel26.setNum(26);
        cellPanel19 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel19.setNum(19);
        cellPanel18 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel18.setNum(18);
        cellPanel11 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel11.setNum(11);
        cellPanel10 = new fr.call_of_rum.boundary.presentation.CellPanel();
        cellPanel10.setNum(10);
        backgroundLabel = new javax.swing.JLabel();
        tokenPanelPlayer1 = new fr.call_of_rum.boundary.presentation.TokenPanel();
        tokenPanelPlayer1.setBoardPanel(this);
        tokenPanelPlayer1.setPlayer(Player.BILL_JAMBE_DE_BOIS);
        tokenPanelPlayer2 = new fr.call_of_rum.boundary.presentation.TokenPanel();
        tokenPanelPlayer2.setBoardPanel(this);
        tokenPanelPlayer2.setPlayer(Player.JACK_LE_BORGNE);

        setMinimumSize(new java.awt.Dimension(600, 500));

        backgroundLabel.setMinimumSize(new java.awt.Dimension(600, 500));
        backgroundLabel.setPreferredSize(new java.awt.Dimension(600, 500));

        setLayer(cellPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel30, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel29, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel28, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(cellPanel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(backgroundLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(tokenPanelPlayer1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(tokenPanelPlayer2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tokenPanelPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420)
                .addComponent(cellPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(cellPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(cellPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cellPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tokenPanelPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cellPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(cellPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cellPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cellPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cellPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(cellPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tokenPanelPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cellPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cellPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cellPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cellPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cellPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tokenPanelPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cellPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cellPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(cellPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cellPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(cellPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setCellsType(CellType[] cellsType) {
        for (int i=0;i<30;i++){
            cellsPanel[i].setType(cellsType[i]);
        }
    }

    public void chestOpened(int numCell){
        cellsPanel[numCell].setType(CellType.OPENED_CHEST);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel1;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel10;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel11;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel12;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel13;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel14;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel15;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel16;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel17;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel18;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel19;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel2;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel20;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel21;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel22;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel23;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel24;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel25;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel26;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel27;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel28;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel29;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel3;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel30;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel4;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel5;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel6;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel7;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel8;
    private fr.call_of_rum.boundary.presentation.CellPanel cellPanel9;
    private fr.call_of_rum.boundary.presentation.TokenPanel tokenPanelPlayer1;
    private fr.call_of_rum.boundary.presentation.TokenPanel tokenPanelPlayer2;
    // End of variables declaration//GEN-END:variables
}
