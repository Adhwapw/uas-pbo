/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas;

/**
 *
 * @author adhwa
 */
public class UserSession {
    private static UserSession instance;

    private String idUser;
    private String namaUser;
    private String alamatU;
    private String nomortelepon;
    private String email;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUser(String idUser, String namaUser, String alamatU, String nomortelepon, String email) {
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.alamatU = alamatU;
        this.nomortelepon = nomortelepon;
        this.email = email;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }
    
    public String getAlamatUser() {
        return alamatU;
    }
    
    public String getNoTelponUser() {
        return nomortelepon;
    }
    
     public String getEmail() {
        return email;
    }
    
    public void clearSession() {
        idUser = "0";
        namaUser = null;
    }
}
