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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import marikita_uap.Penjualan;
/**
 * FXML Controller class
 *
 * @author Myshel wihasna p
 */
public class PenjualanOutputController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    @FXML
    private TableColumn<Penjualan,Double> Charga;

    @FXML
    private TableColumn<Penjualan,Integer> Cjumlah;

    @FXML
    private TableColumn<Penjualan,String> Cnama;

    @FXML
    private TableColumn<Penjualan,Integer> Cstok;
     
    @FXML
    private TableView<Penjualan> tbDatapenjualan;
    
    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;
    
    @FXML
    private ImageView imgGambar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showPenjualan();
    } 

    @FXML
    void back(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/Tampilan.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnBack.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanDelete.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnDelete.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void update(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanInput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnUpdate.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
   public ObservableList<Penjualan> getPenjualanList(){
       ObservableList<Penjualan> penjualanList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM penjualan;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Penjualan pj;
           while(rs.next()){
              pj = new Penjualan(rs.getString("nama_produk"),rs.getInt("jumlahProduk"),rs.getInt("stok"),rs.getDouble("harga"));
               penjualanList.add(pj);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return penjualanList;
   }
    public void showPenjualan(){
       ObservableList<Penjualan> list = getPenjualanList();
       Cnama.setCellValueFactory(new PropertyValueFactory<Penjualan,String>("nama_produk"));
       Cjumlah.setCellValueFactory(new PropertyValueFactory<Penjualan,Integer>("jumlahProduk"));
       Cstok.setCellValueFactory(new PropertyValueFactory<Penjualan,Integer>("stok"));
       Charga.setCellValueFactory(new PropertyValueFactory<Penjualan,Double>("harga"));
       
       tbDatapenjualan.setItems(list);
   } 
    
}
