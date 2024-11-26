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
import uas.PrintTable;

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
            model.addColumn("Metode Pembayaran");
            model.addColumn("ID Produk");

            // Loop hasil query dan tambahkan ke model
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_order"),
                    rs.getString("id_user"),
                    rs.getString("order_date"),
                    rs.getString("subtotal"),
                    rs.getString("payment_status"),
                    rs.getString("status"),
                    rs.getString("quantity"),
                    rs.getString("metode_bayar"),
                    rs.getString("id_product")
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
    private void searchTable(String keyword) {
    try {
        // Hubungkan ke database
        Koneksi db = new Koneksi();
        Connection con = db.connect();

        // Query untuk mencari data berdasarkan keyword
        String sql = "SELECT o.id_order, o.id_user, o.order_date, o.subtotal, o.payment_status, "
                   + "o.status, o.quantity, o.metode_bayar, o.id_product "
                   + "FROM orders o "
                   + "WHERE o.id_order LIKE ? OR o.id_user LIKE ? OR o.order_date LIKE ? "
                   + "OR o.subtotal LIKE ? OR o.payment_status LIKE ? OR o.status LIKE ? "
                   + "OR o.quantity LIKE ? OR o.metode_bayar LIKE ? OR o.id_product LIKE ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        // Set parameter query dengan keyword pencarian
        for (int i = 1; i <= 9; i++) {
            stmt.setString(i, "%" + keyword + "%");
        }

        ResultSet rs = stmt.executeQuery();

        // Dapatkan model tabel
        DefaultTableModel model = (DefaultTableModel) tabeltransaksi.getModel();

        // Kosongkan tabel sebelum mengisi ulang data
        model.setRowCount(0);

        // Loop hasil query dan tambahkan ke model
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_order"),
                rs.getString("id_user"),
                rs.getString("order_date"),
                rs.getString("subtotal"),
                rs.getString("payment_status"),
                rs.getString("status"),
                rs.getString("quantity"),
                rs.getString("metode_bayar"),
                rs.getString("id_product")
            });
        }

        // Set model ke JTable
        tabeltransaksi.setModel(model);

        // Tutup koneksi
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal mencari data: " + ex.getMessage());
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
        rSButtonIconD1 = new rojerusan.RSButtonIconD();
        rSButtonIconD3 = new rojerusan.RSButtonIconD();
        rSButtonIconD4 = new rojerusan.RSButtonIconD();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
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
        btndataadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menuadmin/gambar/icons8-admin-25.png"))); // NOI18N
        btndataadmin.setText("Data User");
        btndataadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndataadminActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btndataadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        rSButtonIconD2.setBackground(new java.awt.Color(255, 153, 153));
        rSButtonIconD2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menuadmin/gambar/9044816_product_icon.png"))); // NOI18N
        rSButtonIconD2.setText("Data Produk");
        rSButtonIconD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconD2ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonIconD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, -1));

        rSButtonIconD1.setBackground(new java.awt.Color(255, 153, 153));
        rSButtonIconD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menuadmin/gambar/10758945_notes_icon (1).png"))); // NOI18N
        rSButtonIconD1.setText("Transaksi");
        rSButtonIconD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconD1ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonIconD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 40));

        rSButtonIconD3.setBackground(new java.awt.Color(255, 153, 153));
        rSButtonIconD3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menuadmin/gambar/1291768_delivery_fast_quick_truck_logistics_icon.png"))); // NOI18N
        rSButtonIconD3.setText("Pengiriman");
        rSButtonIconD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconD3ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonIconD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, 40));

        rSButtonIconD4.setBackground(new java.awt.Color(255, 153, 153));
        rSButtonIconD4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menuadmin/gambar/2931177_output_print_printer_icon.png"))); // NOI18N
        rSButtonIconD4.setText("Cetak");
        rSButtonIconD4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconD4ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonIconD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 40));

        search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        kGradientPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 160, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cari");
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

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

    private void rSButtonIconD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconD1ActionPerformed
        // TODO add your handling code here:
        admintransaksi p = new admintransaksi();
        p.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_rSButtonIconD1ActionPerformed

    private void rSButtonIconD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconD3ActionPerformed
        // TODO add your handling code here:
        adminpengiriman p = new adminpengiriman();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonIconD3ActionPerformed

    private void rSButtonIconD4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconD4ActionPerformed
        // TODO add your handling code here:
        PrintTable printer = new PrintTable();
        printer.printToPDF(tabeltransaksi); // tabeltransaksi adalah JTable Anda

    }//GEN-LAST:event_rSButtonIconD4ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        String keyword = search.getText();
        searchTable(keyword);
    }//GEN-LAST:event_searchKeyReleased

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JPanel mainpanel;
    private efectos.MaterialColor materialColor1;
    private javax.swing.JPanel pnback;
    private rojerusan.RSButtonIconD rSButtonIconD1;
    private rojerusan.RSButtonIconD rSButtonIconD2;
    private rojerusan.RSButtonIconD rSButtonIconD3;
    private rojerusan.RSButtonIconD rSButtonIconD4;
    private javax.swing.JTextField search;
    private javax.swing.JTable tabeltransaksi;
    // End of variables declaration//GEN-END:variables
}
