/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menuadmin.tampilan;

/**
 *
 * @author adhwa
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uas.Koneksi;

public class dataproduk extends javax.swing.JFrame {

    /**
     * Creates new form dataproduk
     */
    public void clearForm() {
        txtnama.setText("");
        txtkategori.setText("");
        txtdeskripsi.setText("");
        txtharga.setText("");
        txtstok.setText("");
    }

    private void loadTable() {
        try {
            // Hubungkan ke database
            Koneksi db = new Koneksi();
            Connection conn = db.connect();

            // Query untuk mengambil data dari tabel users
            String sql = "SELECT * FROM products";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Buat model untuk JTable
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Produk");
            model.addColumn("Nama Produk");
            model.addColumn("Kategori");
            model.addColumn("Harga");
            model.addColumn("Stok");
            model.addColumn("Deskripsi");

            // Loop hasil query dan tambahkan ke model
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_product"),
                    rs.getString("nama"),
                    rs.getString("kategori"),
                    rs.getString("harga"),
                    rs.getString("stok"),
                    rs.getString("deskripsi")
                });
            }

            // Set model ke JTable
            tabelproduk.setModel(model);

            // Tutup koneksi
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + ex.getMessage());
        }
    }

    private void tampilkanDataKeField(int selectedRow) {
        try {
            // Ambil data dari JTable berdasarkan baris yang dipilih
            String idProduct = tabelproduk.getValueAt(selectedRow, 0).toString();
            String nama = tabelproduk.getValueAt(selectedRow, 1).toString();
            String kategori = tabelproduk.getValueAt(selectedRow, 2).toString();
            String harga = tabelproduk.getValueAt(selectedRow, 3).toString();
            String stok = tabelproduk.getValueAt(selectedRow, 4).toString();
            String deskripsi = tabelproduk.getValueAt(selectedRow, 5).toString();

            // Set data ke field input
            txtnama.setText(nama);
            txtkategori.setText(kategori);
            txtharga.setText(harga);
            txtstok.setText(stok);
            txtdeskripsi.setText(deskripsi);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data ke field: " + ex.getMessage());
        }
    }

    private void searchTable(String keyword) {
        try {
            // Hubungkan ke database
            Koneksi db = new Koneksi();
            Connection conn = db.connect();

            // Query untuk mencari data berdasarkan keyword pada nama atau kategori
            String sql = "SELECT * FROM products WHERE nama LIKE ? OR kategori LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            // Buat model untuk JTable
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Produk");
            model.addColumn("Nama Produk");
            model.addColumn("Kategori");
            model.addColumn("Harga");
            model.addColumn("Stok");
            model.addColumn("Deskripsi");

            // Loop hasil query dan tambahkan ke model
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_product"),
                    rs.getString("nama"),
                    rs.getString("kategori"),
                    rs.getString("harga"),
                    rs.getString("stok"),
                    rs.getString("deskripsi")
                });
            }

            // Set model ke JTable
            tabelproduk.setModel(model);

            // Tutup koneksi
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencari data: " + ex.getMessage());
        }
    }

    public dataproduk() {
        initComponents();
        loadTable();
        tabelproduk.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tabelproduk.getSelectedRow();
                if (selectedRow != -1) {
                    tampilkanDataKeField(selectedRow);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelproduk = new javax.swing.JTable();
        txtnama = new javax.swing.JTextField();
        txtkategori = new javax.swing.JTextField();
        txtdeskripsi = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnhapusproduk = new javax.swing.JButton();
        btneeditproduk = new javax.swing.JButton();
        btntambahproduk = new javax.swing.JButton();
        txtstok = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelproduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Produk", "Nama Produk", "Title 3", "Title 4"
            }
        ));
        tabelproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelprodukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelproduk);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 475, -1));

        txtnama.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 128, 145, -1));

        txtkategori.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kategori", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(txtkategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 128, 145, -1));

        txtdeskripsi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deskripsi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(txtdeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 179, 334, -1));

        txtharga.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 142, -1));

        search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 23, 159, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Data Produk");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 150, 60));

        btnhapusproduk.setText("Hapus");
        btnhapusproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapusproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, -1));

        btneeditproduk.setText("Edit");
        btneeditproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneeditprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btneeditproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, -1, -1));

        btntambahproduk.setText("Simpan");
        btntambahproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btntambahproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, -1, -1));

        txtstok.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stok", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 142, -1));

        jButton1.setText("Kembali");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        String keyword = search.getText();
        searchTable(keyword);
    }//GEN-LAST:event_searchKeyReleased

    private void btnhapusprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusprodukActionPerformed
        int selectedRow = tabelproduk.getSelectedRow();
        if (selectedRow != -1) {
            String idProduct = tabelproduk.getValueAt(selectedRow, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus produk ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Koneksi db = new Koneksi();
                    Connection conn = db.connect();

                    // Query delete data
                    String sql = "DELETE FROM products WHERE id_product = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, idProduct);

                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data produk berhasil dihapus!");
                    loadTable(); // Refresh tabel
                    clearForm(); // Kosongkan form
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus!");
        }
    }//GEN-LAST:event_btnhapusprodukActionPerformed

    private void btneeditprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneeditprodukActionPerformed
// Validasi input agar tidak ada field kosong
        if (txtnama.getText().isEmpty() || txtkategori.getText().isEmpty() || txtharga.getText().isEmpty()
                || txtstok.getText().isEmpty() || txtdeskripsi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Ambil data dari field input
            int selectedRow = tabelproduk.getSelectedRow(); // Pastikan ada baris yang dipilih
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit dari tabel!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Ambil ID produk dari baris yang dipilih
            String idProduk = tabelproduk.getValueAt(selectedRow, 0).toString();

            String nama = txtnama.getText();
            String kategori = txtkategori.getText();
            String harga = txtharga.getText();
            String stok = txtstok.getText();
            int value = Integer.parseInt(stok);
            String deskripsi = txtdeskripsi.getText();

            // Hubungkan ke database
            Koneksi db = new Koneksi();
            Connection conn = db.connect();

            // Query untuk update data
            String sql = "UPDATE products SET nama = ?, kategori = ?, harga = ?, stok = ?, deskripsi = ? WHERE id_product = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, kategori);
            stmt.setString(3, harga);
            stmt.setInt(4, value);
            stmt.setString(5, deskripsi);
            stmt.setString(6, idProduk);

            // Eksekusi query
            int updated = stmt.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
                loadTable(); // Refresh tabel setelah update
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui data!");
            }

            // Tutup koneksi
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saat memperbarui data: " + ex.getMessage());
        }
    }//GEN-LAST:event_btneeditprodukActionPerformed

    private void btntambahprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahprodukActionPerformed
        try {
            Koneksi db = new Koneksi();
            Connection conn = db.connect();

            // Query insert ke tabel products
            String sql = "INSERT INTO products (id_product, nama, kategori, deskripsi, harga, stok) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Buat ID produk unik (misalnya P001, P002, ...)
            String idProduct = "P" + System.currentTimeMillis(); // Bisa gunakan metode lain untuk format ID

            // Set parameter input dari user
            stmt.setString(1, idProduct);
            stmt.setString(2, txtnama.getText());
            stmt.setString(3, txtkategori.getText());
            stmt.setString(4, txtdeskripsi.getText());
            stmt.setDouble(5, Double.parseDouble(txtharga.getText()));
            stmt.setString(6, txtstok.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data produk berhasil disimpan!");
            loadTable(); // Refresh tabel
            clearForm(); // Kosongkan form
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }
    }//GEN-LAST:event_btntambahprodukActionPerformed

    private void tabelprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelprodukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelprodukMouseClicked

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
            java.util.logging.Logger.getLogger(dataproduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataproduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataproduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataproduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dataproduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneeditproduk;
    private javax.swing.JButton btnhapusproduk;
    private javax.swing.JButton btntambahproduk;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private javax.swing.JTable tabelproduk;
    private javax.swing.JTextField txtdeskripsi;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtkategori;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
