/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_estructuradedatos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lists.DoublyCircularLinkedList;
import lists.DoublyCircularNodeList;
import lists.DoublyLinkedList;
import modelo.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lists.DoublyCircularLinkedList;
import lists.DoublyCircularNodeList;
import lists.*;
import modelo.*;

/**
 * FXML Controller class
 *
 * @author levin
 */

public class RootWindowController implements Initializable {

    static void initializeData(TextField emailLog) {
        
    }
    
    private Stage stage;
    @FXML
    private Label searchTxt1;
    @FXML
    private ComboBox<String> cvautos;
    @FXML
    private ComboBox<String> cvmarcas;
    @FXML
    private ComboBox<Integer> cvpreciosdesde;
    @FXML
    private ComboBox<Integer> cvprecioshasta;
    @FXML
    private ComboBox<Integer> cvañosdesde;
    @FXML
    private ComboBox<Integer> cvañoshasta;
    @FXML
    private HBox userHbox;
    @FXML
    private Button Buscar;
    @FXML
    private Button volverBtt;
    @FXML
    private Button cleanBtt;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private HBox mainHBox;
    @FXML
    private VBox firstBox;
    @FXML
    private FlowPane optionsFPane;
    @FXML
    private Label searchTxt;
    private ComboBox<String> carFilter;
    private HBox listHBox;
    @FXML
    private VBox detailVBox;
    
    
    private ArrayList<Vehiculo> carros;     
    @FXML
    private FlowPane carrosfp;
    private String user;
    
    public void initializeData(String user){
        Usuario us = Utilidades.obtenerDatosUsuario(user);
        Label lb = new Label(us.getNombre() + " " + us.getApellido());
        lb.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: white");
        userHbox.getChildren().add(lb);
        userHbox.setStyle("-fx-background-color: #670010");
        this.user = user;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView imgviewuser = new ImageView(new Image("imgs/user.png"));
        imgviewuser.setFitHeight(30);
        imgviewuser.setFitWidth(30);
        userHbox.setMargin(imgviewuser,new Insets(0,10,0,0));
        userHbox.getChildren().add(imgviewuser);
        userHbox.setStyle("-fx-border-color: black ; -fx-border-width: 0 0 1px 0;");
        carros= Utilidades.leer();
        
        ObservableList<String> optionsAutos = FXCollections.observableArrayList("Ligero","Motocicleta");      
        cvautos.setItems(optionsAutos);
        
        ObservableList<String> optionsMarcas = FXCollections.observableArrayList(
                "Chevrolet","Honda", "Ducati","Hyundai","Kawasaki", "Renault", "Suzuki", "Toyota", "Yamaha");      
        cvmarcas.setItems(optionsMarcas);   
        
        ObservableList<Integer> optionsPreciosDesde = FXCollections.observableArrayList(
                0,500,1000,1500,2000,2500,3000,3500,4000,5000,6000);      
        cvpreciosdesde.setItems(optionsPreciosDesde);   
        
        ObservableList<Integer> optionsPreciosHasta = FXCollections.observableArrayList(
                1000,1500,2000,2500,3000,3500,4000,5000,6000,7000,8000,9000,10000,20000);      
        cvprecioshasta.setItems(optionsPreciosHasta); 
        
        ObservableList<Integer> optionsAniosDesde = FXCollections.observableArrayList(
                2024,2023,2022,2021,2020,2019,2018,2017,2016,
                2015,2014,2013,2012,2011,2010,2009,2008,2007,
                2006,2005,2004,2003,2004,2003,2002,2001,2000,
                1999,1998,1997,1996,1995,1994,1993,1992,1991);      
        cvañosdesde.setItems(optionsAniosDesde); 
        
        ObservableList<Integer> optionsAniosHasta = FXCollections.observableArrayList(
                2024,2023,2022,2021,2020,2019,2018,2017,2016,
                2015,2014,2013,2012,2011,2010,2009,2008,2007,
                2006,2005,2004,2003,2004,2003,2002,2001,2000,
                1999,1998,1997,1996,1995,1994,1993,1992,1991);      
        cvañoshasta.setItems(optionsAniosDesde); 
        
        
        dibujar(carros);
    }    

    @FXML
    private void filtrar(ActionEvent event) {
        ArrayList<Vehiculo> result = new ArrayList<>();
        
        for(Vehiculo v : carros){
            boolean matches = true;
            
            if(cvautos.getValue() != null && !v.getPeso().equalsIgnoreCase(cvautos.getValue())){
                matches = false;
            }
            if(cvmarcas.getValue() != null && !v.getMarca().getNombre().equalsIgnoreCase(cvmarcas.getValue())){
                matches = false;
            }
            if(cvpreciosdesde.getValue() != null && (v.getPrecio() < cvpreciosdesde.getValue())){
                matches = false;
            }
            if(cvprecioshasta.getValue() != null && (v.getPrecio() > cvprecioshasta.getValue())){
                matches = false;
            }
            if(cvañosdesde.getValue() != null && (v.getAño() < cvañosdesde.getValue())){
                matches = false;
            }
            if(cvañoshasta.getValue() != null && (v.getAño() > cvañoshasta.getValue())){
                matches = false;
            } 
            if(matches){
                result.addLast(v);
            }   

        }
        Platform.runLater(()-> {
            carrosfp.getChildren().clear();
            dibujar(result);
        });
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

    @FXML
    private void volver(ActionEvent event) throws IOException {
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("usuario.fxml"));
            Parent root = loader.load();
            
            UsuarioController controller = loader.getController();

            Scene principal = new Scene(root,1200,700);
            Stage newStage = new Stage();
            newStage.setScene(principal);
            newStage.show();
            controller.setStage(newStage);
            controller.initializeData(user);

            Stage currentStage = (Stage) carrosfp.getScene().getWindow();
            currentStage.close();
    }

    @FXML
    private void filterClean(MouseEvent event) {
        Platform.runLater(()->{
            carrosfp.getChildren().clear();
            dibujar(carros);
        });
        
    }


    
}
