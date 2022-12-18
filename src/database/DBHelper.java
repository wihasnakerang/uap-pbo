/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Myshel wihasna p
 */
public class DBHelper {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DB = "uap_pbo";
    private static final String MYCONN = "jdbc:mysql://localhost:8111/"+DB;
    
    public static Connection getConnection(){
    Connection conn = null;
        try {
            conn = DriverManager.getConnection(MYCONN, USERNAME, PASSWORD);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }
        return conn;
    }  
}
