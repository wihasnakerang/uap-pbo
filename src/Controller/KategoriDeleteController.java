/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.JbdcKategori;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import marikita_uap.Kategori;

/**
 * FXML Controller class
 *
 * @author Myshel wihasna p
 */
public class KategoriDeleteController  {
   JbdcKategori ktg = new JbdcKategori();
    
   @FXML
   private TextField flKategori;
    
   @FXML
   private Button btnHapus;
   
   @FXML
   private Button btnKembali;   
   
   @FXML
   public void hapus (ActionEvent event) throws IOException{
       Kategori ktgo = new Kategori(flKategori.getText());
       ktg.deleteKategori(ktgo);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnHapus.getScene().getWindow();
       stage.setScene(new Scene(root));
   }
   
   @FXML
   public void kembali (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
   }   
    
}
