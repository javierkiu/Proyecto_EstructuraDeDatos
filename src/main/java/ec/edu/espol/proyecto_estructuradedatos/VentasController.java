/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_estructuradedatos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lists.ArrayList;
import modelo.Utilidades;
import modelo.Vehiculo;
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
    @FXML
    private Button backBtt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
    }    

    void initializeData(String user) {
        this.user = user;
        dibujar(Utilidades.obtenerDatosUsuario(user).getEnVenta());
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
    
    
    
    public boolean dibujar(ArrayList<Vehiculo> carros){
        if(carros.isEmpty()) return false;
        VBox vb;
        ImageView iv;
        Label lb1; 
        Label lb2;
        Label lb3;
        String st1;
        String st2;
        String st3;

        for(Vehiculo v : carros){
            vb = new VBox();
            iv = new ImageView(new Image("imgs/"+v.getFotos().getLast().getcontent()+".jpg"));
            st1 = v.getMarca().getNombre() + " " + v.getModelo();
            lb1 = new Label(st1.toUpperCase());
            lb1.setStyle("-fx-font-weight: bold;");
           
            st2 = Double.toString(v.getPrecio()) + "$";
            lb2 = new Label(st2);
            lb2.setStyle("-fx-font-weight: bold;");

            st3 = "Año: "+Integer.toString(v.getAño());
            lb3 = new Label(st3);
            lb3.setStyle("-fx-font-weight: bold;");  
            
            iv.setFitHeight(150);
            iv.setFitWidth(225);
            carrosfp.setMargin(vb,new Insets(10, 20, 10, 20));
            vb.setMargin(lb1,new Insets(10,0,10,5));
            vb.setMargin(lb2,new Insets(10,0,10,5));
            vb.setMargin(lb3,new Insets(0,0,0,5));

            vb.setStyle("-fx-border-color: gray; -fx-border-width: 0.5px; -fx-border-style: solid;");

            vb.getChildren().addAll(iv, lb1,lb3,lb2);
            
            vb.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t1) -> {
                generarVistaCarro(v);
            });
            
            carrosfp.getChildren().add(vb);     
        }
        return true;
    }
    
    
    public void generarVistaCarro(Vehiculo v) 
    {
        Platform.runLater(()  -> {
            
            Stage stage = (Stage) carrosfp.getScene().getWindow();
            
            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaCarro.fxml"));
                Parent root = loader.load();
                
                VistaCarroController controller = loader.getController();
                controller.setCarro(v);
                controller.setVistaAutos(stage);
                
                controller.generar();
                
                Scene principal = new Scene(root,1200,700);
                
                Stage newStage = new Stage();
                newStage.setScene(principal);
                newStage.show();
                controller.setStage(newStage);
                
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
                stage.hide();
        });
    }

}
