/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marikita_uap;

import java.util.ArrayList;

/**
 *
 * @author Myshel wihasna p
 */
public class Barang extends Produk {
    private String barcode;
    private String expired;
    private String kategori;
    private ArrayList<Kategori> kateori = new ArrayList<>();
    
    public Barang(){}
    
    public Barang(String barcode){
        this.barcode = barcode;
    }
    
    public Barang(String nama_produk,String kategori){
        super(nama_produk);
        this.kategori = kategori;
    }
    
    public Barang(String barcode,String nama_produk,double harga, int jumlah,double diskon,String expired, String kategori){
        super(nama_produk,harga,jumlah,diskon);
        this.barcode = barcode;
        this.expired = expired;
        this.kategori = kategori;        
    }
    
    public boolean isExpired(){
        return true;
    }   
    public Kategori addKateori(){
       return null;
    } 
    public void printKategori(){

    }

    public String getBarcode() {
        return barcode;
    }
    public String getExpired() {
        return expired;
    }
    public ArrayList<Kategori> getKateori() {
        return kateori;
    }
    public String getKategori() {
        return kategori;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }   
    public void setExpired(String expired) {
        this.expired = expired;
    }
    public void setKateori(ArrayList<Kategori> kateori) {
        this.kateori = kateori;
    }
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
