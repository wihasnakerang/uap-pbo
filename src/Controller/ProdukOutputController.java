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
public class ProdukOutputController implements Initializable {

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
    private Button btnBack;

    @FXML
    private Button btnBarang;

    @FXML
    private Button btnMakanan;

    @FXML
    void back(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/Tampilan.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnBack.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void barang(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnBarang.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void makanan(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnMakanan.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
}
