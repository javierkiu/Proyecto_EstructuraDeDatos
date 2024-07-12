/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_estructuradedatos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lists.ArrayList;
import lists.Iterator;
import modelo.Usuario;
import modelo.Utilidades;
import modelo.Vehiculo;

/**
 * FXML Controller class
 *
 * @author JAVIER
 */
public class VistaCarroFavoritoController implements Initializable {

    @FXML
    private HBox mainHBox;
    @FXML
    private VBox detailVBox;
    @FXML
    private HBox userHbox;
    @FXML
    private Label searchTxt1;
    @FXML
    private Label desc;
    @FXML
    private Button volverBtt;
    @FXML
    private VBox firstBox;
    @FXML
    private FlowPane optionsFPane;
    @FXML
    private Label tittleLbl;
    @FXML
    private HBox buttonfav;
    @FXML
    private Button retrocederBtt;
    @FXML
    private ImageView imagen;
    @FXML
    private Button avanzarBtt;

    
    private Vehiculo carro;
    
    private Stage stage;
    
    private Stage vistaAutos;
    Iterator<String> it;

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


    public void generar()
    {
        it = carro.getFotos().iterator();
        Platform.runLater(()->{
            tittleLbl.setText((carro.getMarca().getNombre() + " " + carro.getModelo()).toUpperCase());
            imagen.setImage(new Image("imgs/" + carro.getFotos().getLast().getcontent() + ".jpg"));
            desc.setText(carro.toString());
        });
        
    }
    public void setCarro(Vehiculo carro) {
        this.carro = carro;
    }
    
    public void setVistaAutos(Stage stage) {
        this.vistaAutos = stage;
    }    

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private void retroceso(MouseEvent event) {
        Platform.runLater(()->{
            imagen.setImage(new Image("imgs/" + it.back() + ".jpg"));
            desc.setText(carro.toString());
        });
    }

    @FXML
    private void avance(MouseEvent event) {
        Platform.runLater(()->{
            imagen.setImage(new Image("imgs/" + it.next() + ".jpg"));
            desc.setText(carro.toString());
        });
    }

    @FXML
    private void volver(MouseEvent event) {
        vistaAutos.show();
        stage.close();
    }
    
 
    @FXML
    private void eliminarFavoritos(MouseEvent event) {
        ArrayList<Usuario> usuarios = Utilidades.leerUsuarios();
        Usuario us = Utilidades.obtenerUsuario(user);
        int index = usuarios.getIndex(us);
        Alert al;
        if(us.getFavoritos().contains(carro)){
            int indexcarro = usuarios.get(index).getFavoritos().getIndex(carro);
            usuarios.get(index).getFavoritos().remove(indexcarro);      
            Utilidades.serializarUsuarios(usuarios);
            al = new Alert(Alert.AlertType.CONFIRMATION, "Se elimino de favoritos!!");
        }
        else al = new Alert(Alert.AlertType.WARNING, "Vehiculo ya no está en favoritos!!");
        al.show();
    }

    @FXML
    private void soltado(MouseEvent event) {
        buttonfav.setStyle("-fx-background-color: white;");
    }

    @FXML
    private void presionado(MouseEvent event) {
        buttonfav.setStyle("-fx-background-color: gray;");
    }
    
}
