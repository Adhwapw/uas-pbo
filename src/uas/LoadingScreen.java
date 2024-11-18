/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author moham
 */
public class LoadingScreen extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public LoadingScreen() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);   //melakukan layar full
        this.setUndecorated(true);
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

        dekstopPane = new javax.swing.JPanel();
        LoadingBar = new javax.swing.JProgressBar();
        LoadingLabel = new javax.swing.JLabel();
        LoadingValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        dekstopPane.setBackground(new java.awt.Color(255, 204, 204));
        dekstopPane.setPreferredSize(new java.awt.Dimension(677, 500));

        LoadingLabel.setBackground(new java.awt.Color(0, 0, 0));
        LoadingLabel.setText("LOADING....");

        LoadingValue.setText("0 %");

        javax.swing.GroupLayout dekstopPaneLayout = new javax.swing.GroupLayout(dekstopPane);
        dekstopPane.setLayout(dekstopPaneLayout);
        dekstopPaneLayout.setHorizontalGroup(
            dekstopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dekstopPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(LoadingLabel)
                .addGap(561, 561, 561)
                .addComponent(LoadingValue))
            .addGroup(dekstopPaneLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dekstopPaneLayout.setVerticalGroup(
            dekstopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dekstopPaneLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addGroup(dekstopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoadingLabel)
                    .addComponent(LoadingValue))
                .addGap(6, 6, 6)
                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dekstopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dekstopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        LoadingScreen ls = new LoadingScreen();
        ls.setVisible(true);
            try {
            for (int i=0;i<=100;i++){
              Thread.sleep(50); //cepat-lambatnya perulangan
              
              ls.LoadingValue.setText(i +"%");
              if(i==20){
               ls.LoadingLabel.setText("Checking For Updates.....");
              }
              if(i==50){
               ls.LoadingLabel.setText("Loading Data Assets.");
              }
              if(i==55){
               ls.LoadingLabel.setText("Loading Data Assets..");
              }
              if(i==60){
               ls.LoadingLabel.setText("Loading Data Assets...");
              }
              if(i==70){
               ls.LoadingLabel.setText("Successfull Loading!");
              }
              if(i==80){
               ls.LoadingLabel.setText("Starting Application, Please Wait!");
              }
              if (i == 100){
              Login login = new Login();
              login.setVisible(true);
              ls.setVisible(false);
              }
              ls.LoadingBar.setValue(i);}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JPanel dekstopPane;
    // End of variables declaration//GEN-END:variables
}
