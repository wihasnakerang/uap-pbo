/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static database.DBHelper.getConnection;
import database.JbdcBarang;
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
public class KategoriOutputController implements Initializable {
    JbdcBarang brg = new JbdcBarang();
    /**
     * Initializes the controller class.
     */
    
        @FXML
    private TableColumn<Barang, String> CKategori;
    
    @FXML
    private TableColumn<Barang, String> CNama;

    @FXML
    private Button btnKembali;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private TableView<Barang> Tkategori;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showKategori();     
    }    
     
   @FXML
    public void kembali(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/Tampilan.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
    
    @FXML
    public void delete(ActionEvent event)throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriDelete.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnDelete.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
   
     public ObservableList<Barang> getBarangList(){  
       ObservableList<Barang> barangList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT nama_produk,kategori FROM barang ;";
       Statement st;
       ResultSet rs; 
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Barang barang;
           while(rs.next()){
              barang = new Barang(rs.getString("nama_produk"),rs.getString("kategori"));
               barangList.add(barang);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return barangList;
    }
     
     public void showKategori(){
       ObservableList<Barang> list = getBarangList();
       CNama.setCellValueFactory(new PropertyValueFactory<Barang,String>("nama_produk"));
       CKategori.setCellValueFactory(new PropertyValueFactory<Barang,String>("kategori"));
       Tkategori.setItems(list);     
   }  
    
}
