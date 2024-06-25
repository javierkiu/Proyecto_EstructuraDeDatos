/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_estructuradedatos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modelo.*;
import lists.*;

/**
 * FXML Controller class
 *
 * @author JAVIER
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button iniSesBt;
    @FXML
    private TextField emailLog;
    @FXML
    private TextField passwordLog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrar(MouseEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void inicio(ActionEvent event) throws IOException {
        if(iniSesBt.getText().equals("") || passwordLog.getText().equals("")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Ingresar todos los campos!!");
            a.show();
        }
        else if(!Utilidades.obtenerIdentificadores().contains(emailLog.getText())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Email o Usuario no registrado!!");
            a.show();
        }
        else if (!Utilidades.obtenerDatosUsuario(emailLog.getText()).getContrasena().equals(passwordLog.getText())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Contrasena incorrecta!!");
            a.show();
        }
        else{
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Sesion iniciada!!");
            a.show();
            
            
            // CANBIAR DE ESCENARIO
        }
        
    }
    
}
