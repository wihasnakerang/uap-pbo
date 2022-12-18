/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marikita_uap.Penjualan;

/**
 *
 * @author Myshel wihasna p
 */
public class JbdcPenjualan {
   private final Connection CONN;
    
    public JbdcPenjualan(){
        this.CONN = DBHelper.getConnection();
    }
    public void addPenjualan(Penjualan pj){
        String insert = "INSERT INTO penjualan VALUES ('"+pj.getNama_produk()+"','"
                + pj.getJumlahProduk() + "', '" + pj.getStok()+"','"+pj.getHarga()+"');"; 
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Dimasukkan");
           }else{
               System.out.println("Data yang dimasukkan sudah ada");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }
         
     public void deletePenjualan(Penjualan pj){//menghapus data didalam query
        String delete = "DELETE FROM penjualan WHERE nama_produk = '"+ pj.getNama_produk()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
           }else{
               System.out.println("Data Gagal dihapus");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }  
    }    
}
