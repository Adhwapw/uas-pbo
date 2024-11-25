/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menuadmin.tampilan;

import static uas.Register.main;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import uas.Koneksi;

/**
 *
 * @author adhwa
 */
public class admintransaksi extends javax.swing.JFrame {

    users u = new users();

    /**
     * Creates new form admin
     */
    public admintransaksi() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);   //melakukan layar full
        this.setUndecorated(true);
        initComponents();
        loadTable();
    }
    private void loadTable() {
        try {
            // Hubungkan ke database
            Koneksi db = new Koneksi();
            Connection con = db.connect();

            // Query untuk mengambil data dari tabel users
            String sql = "SELECT * FROM orders";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Buat model untuk JTable
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Order");
            model.addColumn("ID user");
            model.addColumn("Order Date");
            model.addColumn("Total");
            model.addColumn("Payment Status");
            model.addColumn("Order Status");
            model.addColumn("Quantity");
            model.addColumn("Payment Method");
            model.addColumn("ID Produk");

            // Loop hasil query dan tambahkan ke model
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_order"),
                    rs.getString("id_user"),
                    rs.getString("order_date"),
                    rs.getString("payment_status"),
                    rs.getString("status"),
                    rs.getString("quantity"),
                    rs.getString("metode_bayar"),
                    rs.getString("id_produk")
                });
            }

            // Set model ke JTable
            tabeltransaksi.setModel(model);

            // Tutup koneksi
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + ex.getMessage());
        }
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialColor1 = new efectos.MaterialColor();
        pnback = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        exit15 = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        btndataadmin = new rojerusan.RSButtonIconD();
        rSButtonIconD2 = new rojerusan.RSButtonIconD();
        mainpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeltransaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(1279, 646));

        pnback.setBackground(new java.awt.Color(255, 255, 255));
        pnback.setPreferredSize(new java.awt.Dimension(1279, 646));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 245, 228));
        kGradientPanel1.setkGradientFocus(900);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 227, 225));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 5);
        flowLayout1.setAlignOnBaseline(true);
        kGradientPanel1.setLayout(flowLayout1);

        exit15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exit15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit15.setText("X");
        exit15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit15MouseClicked(evt);
            }
        });
        kGradientPanel1.add(exit15);

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 204, 204));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btndataadmin.setBackground(new java.awt.Color(255, 148, 148));
        btndataadmin.setText("Data User");
        btndataadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndataadminActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btndataadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        rSButtonIconD2.setBackground(new java.awt.Color(255, 153, 153));
        rSButtonIconD2.setText("Data Produk");
        rSButtonIconD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconD2ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonIconD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, -1));

        mainpanel.setLayout(new java.awt.CardLayout());

        tabeltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabeltransaksi);

        mainpanel.add(jScrollPane1, "card2");

        javax.swing.GroupLayout pnbackLayout = new javax.swing.GroupLayout(pnback);
        pnback.setLayout(pnbackLayout);
        pnbackLayout.setHorizontalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbackLayout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE))
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnbackLayout.setVerticalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbackLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pnback, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndataadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndataadminActionPerformed
    admindatauser u = new admindatauser();
        u.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btndataadminActionPerformed

    private void rSButtonIconD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconD2ActionPerformed
    admindataproduk p = new admindataproduk();
        p.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_rSButtonIconD2ActionPerformed

    private void exit15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit15MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit15MouseClicked

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
            java.util.logging.Logger.getLogger(admintransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admintransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admintransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admintransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admintransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconD btndataadmin;
    private javax.swing.JLabel exit15;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JPanel mainpanel;
    private efectos.MaterialColor materialColor1;
    private javax.swing.JPanel pnback;
    private rojerusan.RSButtonIconD rSButtonIconD2;
    private javax.swing.JTable tabeltransaksi;
    // End of variables declaration//GEN-END:variables
}
