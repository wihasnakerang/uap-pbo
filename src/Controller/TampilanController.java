/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Myshel wihasna p
 */
public class TampilanController implements Initializable {

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
    private Button btnData;

    @FXML
    private Button btnKategori;

    @FXML
    private Button btnProduk;

    @FXML
    void dataPenjualan(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnData.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void kategori(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKategori.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void produk(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/ProdukOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnProduk.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
    
}
