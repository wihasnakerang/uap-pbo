/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.JbdcPenjualan;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import marikita_uap.Penjualan;

/**
 * FXML Controller class
 *
 * @author Myshel wihasna p
 */
public class PenjualanInputController implements Initializable {
        JbdcPenjualan pj =new JbdcPenjualan();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @FXML
    private TextField flHarga;

    @FXML
    private TextField flJumlah;

    @FXML
    private TextField flNama;

    @FXML
    private TextField flStok;

    @FXML
   public void kembali (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
   }

    @FXML
   public void tambah (ActionEvent event) throws IOException{
       Penjualan p1 = new Penjualan(flNama.getText(),Integer.parseInt(flJumlah.getText()),Integer.parseInt(flStok.getText()),Double.parseDouble(flHarga.getText()));
       pj.addPenjualan(p1);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnTambah.getScene().getWindow();
       stage.setScene(new Scene(root));
   }  
}
