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
import marikita_uap.Barang;
import marikita_uap.Kategori;
//import marikita_uap.Produk;

/**
 *
 * @author Myshel wihasna p
 */
public class JbdcBarang {
    private final Connection CONN;
    
    public JbdcBarang(){
        this.CONN = DBHelper.getConnection();
    }
    public void addBarang(Barang brg){
        String insert = "INSERT INTO barang VALUES ('"+brg.getBarcode()+"','"+brg.getNama_produk()+
                                                    "','"+brg.getHarga()+"','"+brg.getJumlah()+
                                                    "','"+brg.getDiskon()+"','"+brg.getExpired()+"','"+brg.getKategori()+"');";
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Dimasukkan");
           }else{
               System.out.println("Data yang dimasukkan sudah ada");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcBarang.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }    
     public void deleteProduk(Barang brg){//menghapus data didalam query
        String delete = "DELETE FROM barang WHERE barcode = '"+ brg.getBarcode()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
           }else{
               System.out.println("Data Gagal dihapus");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcBarang.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }  
    }
     
    public void selectProduk(Kategori ktg){
        String select = "SELECT FROM barang WHERE barcode = '"+ ktg.getNama_kategori()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(select)>0){
            System.out.println("Data Berhasil Ditampilkan");
           }else{
               System.out.println("Data Gagal ditampilkan");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcBarang.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal ditampilkan");
        } 
    }     
    
    public void deleteKategori(Barang brg){//menghapus data didalam query
        String delete = "DELETE FROM barang WHERE kategori = '"+ brg.getKategori()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
           }else{
               System.out.println("Data Gagal dihapus");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcBarang.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }  
    }
}
