/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import fr.call_of_rum.boundary.dialog.IDialog;
import fr.call_of_rum.util.Player;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Solène
 */
public class TokenPanel extends javax.swing.JPanel {

    private BoardPanel boardPanel;
    private Player player;
    private int posX;
    private int posY;
    private CellPanel position;
    private IDialog dialog;
    private int newX;
    private int newY;
    private CellPanel wrongPosition=null;
    
    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
    public void setPlayer(Player player) {
        this.player = player;
        putImageToken();
    }
    public CellPanel getPosition(){
        return position;
    }
    
    public void setPosition(CellPanel position){
        this.position=position;
    }
    
    public void setDialog(IDialog dialog){
        this.dialog=dialog;
    }
    /**
     * Creates new form PiecePanel
     */
    public TokenPanel() {
        initComponents();
    }
    
    public void putImageToken(){
        BufferedImage typeImage = ImageLoader.loadImage("presentation/"+player+".png");
        Image scaledTypeImage;
        scaledTypeImage = typeImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon typeIcon = new ImageIcon(scaledTypeImage);
        tokenLabel.setIcon(typeIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tokenLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(70, 70));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(70, 70));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        setLayout(null);

        tokenLabel.setMinimumSize(new java.awt.Dimension(70, 70));
        tokenLabel.setPreferredSize(new java.awt.Dimension(70, 70));
        add(tokenLabel);
        tokenLabel.setBounds(0, 0, 70, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (this.isEnabled()){
            posX=evt.getX();
            posY=evt.getY();
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (this.isEnabled()){
            if (wrongPosition!=null){
                wrongPosition.setNumColor(Color.white);
                repaint();
            }
            int depX = evt.getX() - posX;
            int depY = evt.getY() - posY;
            newX=getX()+depX;
            newY=getY()+depY;        
            if ((newX>(boardPanel.getX()+boardPanel.getWidth())) 
                    ||(newX<boardPanel.getX()) 
                    ||(newY<0)
                    ||(newY>boardPanel.getHeight())){
                this.setLocation(position.getX(), position.getY());
            }else{
                this.setLocation(newX, newY);
            }
            repaint();
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (this.isEnabled()){
            Component initialCell = boardPanel.getComponentAt(position.getX(), position.getY());
            Component arrivalCell=boardPanel.getComponentAt(newX-newX%100, newY-newY%100);
            if (arrivalCell instanceof CellPanel){
                if ((dialog.getDicesResult()+((CellPanel) initialCell).getNum())%30 == ((CellPanel) arrivalCell).getNum()){
                    position=boardPanel.getCellsPanel()[(((CellPanel)arrivalCell).getNum())-1]; //On récupère la position du pion. 
                    dialog.move();
                    this.setEnabled(false);
                }else{
                    wrongPosition=((CellPanel) arrivalCell);
                    ((CellPanel) arrivalCell).setNumColor(Color.red);
                    this.setLocation(position.getX(), position.getY());
                }
                repaint();
            }
        }
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel tokenLabel;
    // End of variables declaration//GEN-END:variables
}
