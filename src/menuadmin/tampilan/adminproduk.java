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
public class adminproduk extends javax.swing.JFrame {

    users u = new users();

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
            Connection con = db.connect();

            // Query untuk mengambil data dari tabel users
            String sql = "SELECT * FROM products";
            PreparedStatement stmt = con.prepareStatement(sql);
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
            con.close();
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
            Connection con = db.connect();

            // Query untuk mencari data berdasarkan keyword pada nama atau kategori
            String sql = "SELECT * FROM products WHERE nama LIKE ? OR kategori LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
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
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencari data: " + ex.getMessage());
        }
    }

    /**
     * Creates new form admin
     */
    public adminproduk() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);   //melakukan layar full
        this.setUndecorated(true);
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

        materialColor1 = new efectos.MaterialColor();
        pnback = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        exit = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        btndataadmin = new rojerusan.RSButtonIconD();
        rSButtonIconD2 = new rojerusan.RSButtonIconD();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelproduk = new javax.swing.JTable();
        txtnama = new javax.swing.JTextField();
        txtkategori = new javax.swing.JTextField();
        txtdeskripsi = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btneeditproduk = new javax.swing.JButton();
        btntambahproduk = new javax.swing.JButton();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(1279, 646));

        pnback.setBackground(new java.awt.Color(255, 255, 255));
        pnback.setPreferredSize(new java.awt.Dimension(1279, 646));
        pnback.setVerifyInputWhenFocusTarget(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 245, 228));
        kGradientPanel1.setkGradientFocus(900);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 227, 225));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 5);
        flowLayout1.setAlignOnBaseline(true);
        kGradientPanel1.setLayout(flowLayout1);

        exit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        kGradientPanel1.add(exit);

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 204, 204));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btndataadmin.setBackground(new java.awt.Color(255, 148, 148));
        btndataadmin.setText("Admin");
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

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Data Produk");

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

        txtnama.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        txtkategori.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kategori", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtdeskripsi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deskripsi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtharga.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtstok.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stok", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

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

        jButton1.setText("Kembali");

        btneeditproduk.setText("Edit");
        btneeditproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneeditprodukActionPerformed(evt);
            }
        });

        btntambahproduk.setText("Simpan");
        btntambahproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahprodukActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle1.setText("Hapus");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btneeditproduk)
                                .addGap(39, 39, 39)
                                .addComponent(btntambahproduk)
                                .addGap(45, 45, 45))
                            .addComponent(txtstok, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtharga, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtdeskripsi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnama)
                            .addComponent(jButton1)
                            .addComponent(txtkategori))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneeditproduk)
                    .addComponent(btntambahproduk))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnbackLayout = new javax.swing.GroupLayout(pnback);
        pnback.setLayout(pnbackLayout);
        pnbackLayout.setHorizontalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbackLayout.createSequentialGroup()
                .addGroup(pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnbackLayout.createSequentialGroup()
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnbackLayout.setVerticalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbackLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        getContentPane().add(pnback, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndataadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndataadminActionPerformed
        datauser u = new datauser();
        u.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btndataadminActionPerformed

    private void rSButtonIconD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconD2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonIconD2ActionPerformed

    private void tabelprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelprodukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelprodukMouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        String keyword = search.getText();
        searchTable(keyword);
    }//GEN-LAST:event_searchKeyReleased

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

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

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
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
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

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
            java.util.logging.Logger.getLogger(adminproduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminproduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminproduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminproduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminproduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconD btndataadmin;
    private javax.swing.JButton btneeditproduk;
    private javax.swing.JButton btntambahproduk;
    private javax.swing.JLabel exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private efectos.MaterialColor materialColor1;
    private javax.swing.JPanel pnback;
    private rojerusan.RSButtonIconD rSButtonIconD2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private javax.swing.JTextField search;
    private javax.swing.JTable tabelproduk;
    private javax.swing.JTextField txtdeskripsi;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtkategori;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
