/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marikita_uap;

/**
 *
 * @author Myshel wihasna p
 */
public class Kategori  {
    private Produk produk ;
    private String nama_kategori;
    
    public Kategori() {}
    
    public Kategori(String nama_kategori){
        this.nama_kategori = nama_kategori;
    } 
    
    public Produk getProduk(){
        return produk;
    }   
    public String getNama_kategori() {
        return nama_kategori;
    }
    public void setProduk(Produk produk) {
        this.produk = produk;
    }
    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    } 
}
