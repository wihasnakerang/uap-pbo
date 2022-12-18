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
public class PenjualanDeleteController implements Initializable {
    JbdcPenjualan penjual = new JbdcPenjualan();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private TextField flNamaBarang;

    @FXML
    void hapus(ActionEvent event) throws IOException {
       Penjualan pj = new Penjualan(flNamaBarang.getText());
       penjual.deletePenjualan(pj);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnHapus.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void kembali(ActionEvent event) throws IOException {
       Penjualan pj = new Penjualan(flNamaBarang.getText());
       penjual.deletePenjualan(pj);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
}
