/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.JbdcMakanan;
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
import marikita_uap.Makanan;

/**
 * FXML Controller class
 *
 * @author Myshel wihasna p
 */
public class MakananInputController  {
JbdcMakanan mkn = new JbdcMakanan();
    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
        @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah1;

    @FXML
    private TextField flDayatahan;

    @FXML
    private TextField flDiskon;

    @FXML
    private TextField flHarga;

    @FXML
    private TextField flId;

    @FXML
    private TextField flJumlah;

    @FXML
    private TextField flNama;

    @FXML
    void kembali(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void tambah(ActionEvent event) throws IOException {
       
       Makanan mkn1 = new Makanan(Integer.parseInt(flId.getText()),flNama.getText(),Double.parseDouble(flHarga.getText()),Integer.parseInt(flJumlah.getText()), Double.parseDouble(flDiskon.getText()), Integer.parseInt(flDayatahan.getText()));
       mkn.addMakanan(mkn1);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnTambah1.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
}
