/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moham
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Login1
     */
    public Register() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        minimize = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        kembali = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new rojerusan.RSMetroTextPlaceHolder();
        txtUsername = new rojerusan.RSMetroTextPlaceHolder();
        txtPassword = new rojerusan.RSPasswordTextPlaceHolder();
        txtalamat = new rojerusan.RSMetroTextPlaceHolder();
        txtConfirmPassword = new rojerusan.RSPasswordTextPlaceHolder();
        txtnotlp = new rojerusan.RSMetroTextPlaceHolder();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1279, 646));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(677, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(670, 60));

        minimize.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");

        exit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1162, Short.MAX_VALUE)
                .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("H E L L O !");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel8.setText("Email");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel3.setText("Username");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel4.setText("Kata Sandi");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel5.setText("Konfirmasi kata sandi");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        jButton2.setText("Daftar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 90, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Silahkan masukkan data mu ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        kembali.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kembali.setText("<-");
        kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kembaliMouseClicked(evt);
            }
        });
        jPanel3.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel6.setText("Alamat");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorderColor(new java.awt.Color(255, 204, 204));
        txtEmail.setBotonColor(new java.awt.Color(255, 204, 204));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel3.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 340, 50));

        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorderColor(new java.awt.Color(255, 204, 204));
        txtUsername.setBotonColor(new java.awt.Color(255, 204, 204));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel3.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 340, 50));

        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setPhColor(new java.awt.Color(255, 148, 148));
        txtPassword.setPreferredSize(new java.awt.Dimension(200, 35));
        txtPassword.setSelectionColor(new java.awt.Color(255, 148, 148));
        jPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 340, 50));

        txtalamat.setForeground(new java.awt.Color(0, 0, 0));
        txtalamat.setBorderColor(new java.awt.Color(255, 204, 204));
        txtalamat.setBotonColor(new java.awt.Color(255, 204, 204));
        txtalamat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel3.add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 340, 50));

        txtConfirmPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtConfirmPassword.setPhColor(new java.awt.Color(255, 148, 148));
        txtConfirmPassword.setPreferredSize(new java.awt.Dimension(200, 35));
        txtConfirmPassword.setSelectionColor(new java.awt.Color(255, 148, 148));
        jPanel3.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 340, 50));

        txtnotlp.setForeground(new java.awt.Color(0, 0, 0));
        txtnotlp.setBorderColor(new java.awt.Color(255, 204, 204));
        txtnotlp.setBotonColor(new java.awt.Color(255, 204, 204));
        txtnotlp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel3.add(txtnotlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 340, 50));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel7.setText("No telepon");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1280, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1279, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseClicked
        // TODO add your handling code here:
        Login lgn = new Login();
        lgn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kembaliMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        Register rgs = new Register();
//        Menu scs = new Menu();
//        scs.setVisible(true);
//        rgs.setVisible(false);
// Ambil nilai dari input
        String email = txtEmail.getText();
        String username = txtUsername.getText();
        String notelp = txtnotlp.getText();
        String alamat = txtalamat.getText();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        // Validasi data
        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || notelp.isEmpty() || alamat.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Format email tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password dan Konfirmasi Password tidak sama!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Koneksi ke database
            Koneksi db = new Koneksi();
            Connection conn = db.connect();

            // Ambil ID terakhir dari database
            String getLastIdSql = "SELECT id_user FROM users ORDER BY id_user DESC LIMIT 1";
            PreparedStatement getLastIdStmt = conn.prepareStatement(getLastIdSql);
            ResultSet rs = getLastIdStmt.executeQuery();
            String newId = "U001"; // Default ID jika tidak ada data di database

            if (rs.next()) {
                // Ambil ID terakhir, misalnya "U005"
                String lastId = rs.getString("id_user");
                int nextIdNumber = Integer.parseInt(lastId.substring(1)) + 1; // Ambil angka dan tambahkan 1
                newId = String.format("U%03d", nextIdNumber); // Format ke "U006", "U007", dst.
            }

            // Pengecekan duplikasi username atau email
            String checkSql = "SELECT COUNT(*) FROM users WHERE email = ? OR username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, email);
            checkStmt.setString(2, username);
            ResultSet checkRs = checkStmt.executeQuery();
            checkRs.next();
            if (checkRs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Email atau Username sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Hentikan proses jika duplikasi ditemukan
            }

            // Query untuk insert data
            String sql = "INSERT INTO users (id_user, username, password, email, role, nomor_telepon, alamat) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newId); // Generate ID unik
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, email);
            stmt.setString(5, "customer"); // Default role untuk pengguna baru
            stmt.setString(6, notelp);
            stmt.setString(7, alamat);

            // Eksekusi query
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Pendaftaran berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Reset form
                txtEmail.setText("");
                txtUsername.setText("");
                txtnotlp.setText("");
                txtalamat.setText("");
                txtPassword.setText("");
                txtConfirmPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Pendaftaran gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
                Login lgn = new Login();
                lgn.setVisible(true);
                this.dispose();

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan koneksi database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel kembali;
    private javax.swing.JLabel minimize;
    private rojerusan.RSPasswordTextPlaceHolder txtConfirmPassword;
    private rojerusan.RSMetroTextPlaceHolder txtEmail;
    private rojerusan.RSPasswordTextPlaceHolder txtPassword;
    private rojerusan.RSMetroTextPlaceHolder txtUsername;
    private rojerusan.RSMetroTextPlaceHolder txtalamat;
    private rojerusan.RSMetroTextPlaceHolder txtnotlp;
    // End of variables declaration//GEN-END:variables
}
