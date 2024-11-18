/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas;

/**
 *
 * @author adhwa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Koneksi {
    private Connection Koneksii;
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("sistem berhasil terconnect");
        } catch (ClassNotFoundException ex) {
            System.out.println("sistem tidak berhasil konek");
        }
        String url = "jdbc:mysql://localhost:3306/dstar";
        try {
            Koneksii = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil koneksi Database");
        } catch (SQLException ex) {
            System.out.println("Gagal koneksi Database");
            JOptionPane.showMessageDialog(null, "Tidak ada database!!");

        }
        return Koneksii;
    }
}
