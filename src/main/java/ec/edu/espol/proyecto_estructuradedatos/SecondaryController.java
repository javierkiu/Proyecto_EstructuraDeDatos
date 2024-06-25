package ec.edu.espol.proyecto_estructuradedatos;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modelo.*;

public class SecondaryController {

    @FXML
    private TextField nameRegistro;
    @FXML
    private TextField mailRegistro;
    @FXML
    private TextField passwordRegistro;
    @FXML
    private TextField repasswordRegistro;
    @FXML
    private TextField apellidoRegistro;
    @FXML
    private TextField usuarioRegistro;


    @FXML
    private void goToLog(ActionEvent event) throws IOException  {
        if(nameRegistro.getText().equals("") || mailRegistro.getText().equals("") || 
        passwordRegistro.getText().equals("") || repasswordRegistro.getText().equals("")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Ingresar todos los campos");
            a.setHeaderText("No se han ingresado todos los datos");
            a.show();
        }
        else if(!passwordRegistro.getText().equals(repasswordRegistro.getText())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Contrasenas no coinciden");
            a.setHeaderText("Las contrasenas no coinciden!!");
            a.show(); 
        }
        else if(!Utilidades.verificarUsuario(usuarioRegistro.getText())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Usuario ya en uso");
            a.setHeaderText("Usuario ya en uso! Elegir otro");
            a.show();         
        }
        else{
            Usuario u = new Usuario(usuarioRegistro.getText(), nameRegistro.getText(),
                    apellidoRegistro.getText(),mailRegistro.getText(),passwordRegistro.getText());
            Utilidades.registrarUsuario(u);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Usuario registrado!!");
            a.setHeaderText("Se registro correctamente al usuario");
            a.show(); 
            App.setRoot("primary");
        }
    }

    @FXML
    private void volver(MouseEvent event) throws IOException {
        App.setRoot("primary");

    }
}