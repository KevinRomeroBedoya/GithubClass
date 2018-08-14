/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guthubclase;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Estudiante;

/**
 *
 * @author eduar.diaz
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField add_name;
    
    @FXML
    private TextField add_telef;
    
    @FXML
    private TextField add_code;
    
    @FXML
    private TextField add_carr;
 
    @FXML
    private TextField add_Email;
    
    @FXML
    private Button btn_addStudent;
    
    @FXML
    private Button btn_SaveFile;
    
        
    LinkedList<Estudiante> ListaE;
    
    
    @FXML
    private void Action_addStudent(ActionEvent event) {
       String nombre = add_name.getText();
       String telefono = add_telef.getText();
       String correo = add_Email.getText();
       String codigo = add_code.getText();
       String carrera = add_carr.getText();
       
       Estudiante objE= new Estudiante(nombre, telefono, codigo, carrera, correo);
       ListaE.add(objE);
    }
    
    @FXML
     private void Action_btn_SaveFile(ActionEvent event) {
       Estudiante objV=new Estudiante();
       boolean guardar = objV.crearArchivoXML(ListaE);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListaE=new LinkedList<>();
    }    
    
}
