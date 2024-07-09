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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author JAVIER
 */
public class VentasController implements Initializable {


    @FXML
    private VBox firstBox;
    @FXML
    private FlowPane optionsFPane;
    @FXML
    private FlowPane carrosfp;
    
    private String user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void initializeData(String user) {
        this.user = user;
    }

    @FXML
    private void volver(MouseEvent event) throws IOException {
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("usuario.fxml"));
            Parent root = loader.load();
            
            UsuarioController controller = loader.getController();

            Scene principal = new Scene(root,930,570);
            Stage newStage = new Stage();
            newStage.setScene(principal);
            newStage.show();
            controller.initializeData(user);

            Stage currentStage = (Stage) carrosfp.getScene().getWindow();
            currentStage.close();
    }
    
}
