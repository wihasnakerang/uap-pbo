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
import marikita_uap.Makanan;
import marikita_uap.Produk;

/**
 *
 * @author Myshel wihasna p
 */
public class JbdcMakanan {
    private final Connection CONN;
    
    public JbdcMakanan(){
        this.CONN = DBHelper.getConnection();
    } 
    public void addMakanan(Makanan mkn){
        String insert = "INSERT INTO makanan VALUES ('"+mkn.getId()+"','"+
                                                       mkn.getNama_produk()+"','"+
                                                       mkn.getHarga()+"','"+
                                                       mkn.getJumlah()+"','"+ 
                                                       mkn.getDiskon() + "', '" + 
                                                       mkn.getDaya_tahan()+ "');"; 
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Dimasukkan");
           }else{
               System.out.println("Data yang dimasukkan sudah ada");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }
    
     public void updateProduk(Makanan mkn,Produk prd){
        String update = "UPDATE makanan SET id = '"+mkn.getId()+"', nama_produk = '"+prd.getNama_produk()+
                                        "', harga = '"+prd.getHarga()+"', jumlah = '"+prd.getJumlah()+
                                        "', diskon = '"+prd.getDiskon()+"', daya_tahan = '"+mkn.getDaya_tahan()+
                                        "' WHERE id = '"+mkn.getId()+"';";

        try {
           if( CONN.createStatement().executeUpdate(update)>0){
            System.out.println("Data Berhasil Diperbarui");
           }else{
               System.out.println("Data yang dimasukkan tidak berubah");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
     }
     
     public void deleteProduk(Makanan mkn){
        String delete = "DELETE FROM makanan WHERE id = '"+ mkn.getId()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
           }else{
               System.out.println("Data Gagal dihapus");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(JbdcMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }  
    }
}
