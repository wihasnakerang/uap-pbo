/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static database.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import marikita_uap.Barang;

/**
 * FXML Controller class
 *
 * @author Myshel wihasna p
 */
public class BarangOutputController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
        @Override
    public void initialize(URL url, ResourceBundle rb) {
       showBarang();
    }
        @FXML
    private TableColumn<Barang, String> Cbar;

    @FXML
    private TableColumn<Barang, Double> Cdiskon;

    @FXML
    private TableColumn<Barang, String> Cexpired;

    @FXML
    private TableColumn<Barang, Double> Charga;

    @FXML
    private TableColumn<Barang, Integer> Cjumlah;

    @FXML
    private TableColumn<Barang, String> Ckategori;

    @FXML
    private TableColumn<Barang, String> Cnama;

    @FXML
    private TableView<Barang> TBbarang;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    void delete(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangDelete.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnHapus.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void kembali(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/ProdukOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void tambah(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangInput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnAdd.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    public ObservableList<Barang> getBarangList(){
       ObservableList<Barang> barangList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM barang;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Barang barang;
           while(rs.next()){
              barang = new Barang(rs.getString("barcode"),rs.getString("nama_produk"),rs.getDouble("harga"),rs.getInt("jumlah"),rs.getDouble("diskon"),rs.getString("expired"),rs.getString("kategori"));
               barangList.add(barang);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return barangList;
   }
    public void showBarang(){
       ObservableList<Barang> list = getBarangList();
       Cbar.setCellValueFactory(new PropertyValueFactory<Barang,String>("barcode"));
       Cnama.setCellValueFactory(new PropertyValueFactory<Barang,String>("nama_produk"));
       Charga.setCellValueFactory(new PropertyValueFactory<Barang,Double>("harga"));
       Cjumlah.setCellValueFactory(new PropertyValueFactory<Barang,Integer>("jumlah"));
       Cdiskon.setCellValueFactory(new PropertyValueFactory<Barang,Double>("diskon"));
       Cexpired.setCellValueFactory(new PropertyValueFactory<Barang,String>("expired"));
       Ckategori.setCellValueFactory(new PropertyValueFactory<Barang,String>("kategori"));
       
       TBbarang.setItems(list);
   }
}
