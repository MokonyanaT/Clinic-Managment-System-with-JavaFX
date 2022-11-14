 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmsproject;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Tsiu
 */
public class PatientProfileController implements Initializable {
    
    @FXML
    private TableView<Doctors> tv_doctors;
    @FXML
    private TableColumn<Doctors, String> col_doc_name;
    @FXML
    private TableColumn<Doctors, String> col_doc_surname;
    @FXML
    private TableColumn<Doctors, String> col_spec;
    @FXML
    private TableColumn<Doctors, String> col_status;
    @FXML
    private ComboBox<?> sel_doc;
    @FXML
    private ComboBox<?> sel_time;
    @FXML
    private Button btn_book_ap;
    @FXML
    private Button btn_update;
    @FXML
    private Label lbl_pat_name;
    @FXML
    private Label lbl_pat_surname;
    @FXML
    private Label lbl_pat_phone;
    @FXML
    private Label lbl_pat_address;
    @FXML
    private Button btn_logout;
    
    
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mileyhms", "root", "");
            
            return conn;
           
        }
        catch(Exception ex){
            System.out.print("Error databate connection");
            return null;
        }
        
    }
    public ObservableList<Patients> getPatientsList(){
         System.out.print("Hello");
    ObservableList<Patients> patientList = FXCollections.observableArrayList();
    Connection conn2 = getConnection();
    String query2 = "SELECT * FROM patient";
    Statement st;
    ResultSet rs;
        System.out.print("Hello");
    try{
        st = conn2.createStatement();
        rs = st.executeQuery(query2);
        Patients patients;
        
        System.out.print("Hello");
        while(rs.next()){
            
       System.out.print(rs.getString("address")); //i was console testing
          
         lbl_pat_name.setText(rs.getString("address"));
        }
    
    }
    catch(SQLException ex){
       System.out.print("query not executed");
        }

    return patientList;
    }
     
   
    public ObservableList<Doctors> getDoctorsList(){
    ObservableList<Doctors> doctorsList = FXCollections.observableArrayList();
    Connection conn1 = getConnection();
    String query1 = "SELECT * FROM doctor";
    Statement st2;
    ResultSet rs;
   //System.out.print("Hello");
      
    try{
        st2 = conn1.createStatement();
        rs = st2.executeQuery(query1);
        Doctors doctors;
      
        while(rs.next()){
            doctors = new Doctors(rs.getString("doc_name"),rs.getString("doc_surname"),rs.getString("doc_specialization"),rs.getString("status"));
            doctorsList.add(doctors);
        //lbl_pat_name.setText(rs.getString("doc_name")); //i was console testing    
        }
    
    }
    catch(SQLException ex){
       System.out.print("query not executed");
        }
    return doctorsList;
        
     }

 
    
    
    
    
    
    
    
    
    

    
     public void showPatient(){
         ObservableList<Patients> list = getPatientsList();
   //lbl_pat_name.setText(names);
        // lbl_pat_name.setText(String.valueOf(doctorList)<Doctors,String>("doc_name"));
       //  colpatsurname.setCellValueFactory(new PropertyValueFactory<Patients,String>("pat_surname"));
         //colpatbirth.setCellValueFactory(new PropertyValueFactory<Patients,String>("dob"));
       //  colpatphone.setCellValueFactory(new PropertyValueFactory<Patients,Integer>("phone"));
       // colpataddress.setCellValueFactory(new PropertyValueFactory<Patients,String>("address"));
      
      //tvpatient.setItems(list);
     }
  //___________________________________________________________________________________________________________________   
     public void showDoctors(){
         
         try{ ObservableList<Doctors> list = getDoctorsList();
        col_doc_name.setCellValueFactory(new PropertyValueFactory<Doctors,String>("doc_name"));
         col_doc_surname.setCellValueFactory(new PropertyValueFactory<Doctors,String>("doc_surname"));
         col_spec.setCellValueFactory(new PropertyValueFactory<Doctors,String>("doc_spec"));
         col_status.setCellValueFactory(new PropertyValueFactory<Doctors,String>("doc_status"));
        
         
      
      tv_doctors.setItems(list);
      }catch(Exception ex){
      
      }
        
 
     }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showDoctors();
    }    
    
}
