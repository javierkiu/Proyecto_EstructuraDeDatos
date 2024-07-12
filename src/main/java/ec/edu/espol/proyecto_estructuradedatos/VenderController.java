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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author JAVIER
 */
public class VenderController implements Initializable {

    private String user;

    @FXML
    private TextField modelo;
    @FXML
    private TextField marca;
    @FXML
    private TextField precio;
    @FXML
    private TextField placa;
    @FXML
    private TextField motor;
    @FXML
    private TextField peso;
    @FXML
    private TextField estado;
    @FXML
    private TextField kilometraje;
    @FXML
    private TextField anio;
    @FXML
    private TextField foto;
    private Stage vistaUsuario;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
    
    public Stage getVistaUsuario() {
        return vistaUsuario;
    }

    public void setVistaUsuario(Stage vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    void initializeData(String user) {
        this.user= user;
    }

    @FXML
    private void volver(MouseEvent event) throws IOException {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("usuario.fxml"));
        Parent root = loader.load();

        UsuarioController controller = loader.getController();

        Scene principal = new Scene(root,1100,700);
        Stage newStage = new Stage();
        newStage.setScene(principal);
        newStage.show();
        controller.initializeData(user);

        Stage currentStage = (Stage) modelo.getScene().getWindow();
        currentStage.close();

    }


    @FXML
    private void comprar(ActionEvent event) {
    }

 
}
