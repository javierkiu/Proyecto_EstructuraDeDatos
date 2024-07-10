/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_estructuradedatos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JAVIER
 */
public class UsuarioController implements Initializable {
    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private ImageView imgview;
    @FXML
    private Label bienvenida;
    @FXML
    private VBox verventas;
    @FXML
    private VBox comprar;
    @FXML
    private VBox vender;

    private String user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    void initializeData(String text) {
        bienvenida.setText("Bienvenido "+text);
        user = text;
    }
    @FXML
    private void iraventas(MouseEvent event) throws IOException {
//        FXMLLoader loader = new  FXMLLoader(getClass().getResource("ventas.fxml"));
//        Parent root = loader.load();
//
//        VentasController controller = loader.getController();
//
//        Scene principal = new Scene(root,900,600);
//        Stage newStage = new Stage();
//        newStage.setScene(principal);
//        newStage.show();
//        controller.initializeData(user);
//
//        Stage currentStage = (Stage) bienvenida.getScene().getWindow();
//        currentStage.close();
    }

    @FXML
    private void iracatalogo(MouseEvent event) throws IOException {
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("RootWindow.fxml"));
            Parent root = loader.load();

            RootWindowController controller = loader.getController();

            Scene principal = new Scene(root,1200,700);
            Stage newStage = new Stage();
            newStage.setScene(principal);
            newStage.show();
            controller.initializeData(user);
            controller.setStage(newStage);

            Stage currentStage = (Stage) bienvenida.getScene().getWindow();
            currentStage.close();
    }

    @FXML
    private void iravender(MouseEvent event) {



    }



}