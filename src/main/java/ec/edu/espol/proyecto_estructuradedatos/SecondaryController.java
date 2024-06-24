package ec.edu.espol.proyecto_estructuradedatos;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

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
    private void goToLog(ActionEvent event) throws IOException  {
        if(nameRegistro.getText().equals("") || mailRegistro.getText().equals("") || 
        passwordRegistro.getText().equals("") || repasswordRegistro.getText().equals("")){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Ingresar todos los campos");
            a.setHeaderText("No se han ingresado todos los datos");
            a.show();
        }
        else if(!passwordRegistro.getText().equals(repasswordRegistro.getText())){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Contrasenas no coinciden");
            a.setHeaderText("Las contrasenas no coinciden!!");
            a.show(); 
        }
        else{
            App.setRoot("primary");
        }
    }
}