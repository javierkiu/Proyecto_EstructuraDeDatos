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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        lb.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: white;");
        userHbox.getChildren().add(lb);
        this.user = user;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Negocio ng = new Negocio();
        ng.setAutosEnVenta(carros);
                
                
        ImageView imgviewuser = new ImageView(new Image("imgs/user.png"));
        imgviewuser.setFitHeight(30);
        imgviewuser.setFitWidth(30);
        userHbox.setMargin(imgviewuser,new Insets(0,10,0,0));
        userHbox.getChildren().add(imgviewuser);
        userHbox.setStyle("-fx-border-color: black ; -fx-border-width: 0 0 1px 0;-fx-background-color:  #670010");
        
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
        cvañoshasta.setItems(optionsAniosHasta); 
        
        
        Utilidades.dibujar(carros,carrosfp);
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
        carrosfp.getChildren().clear();
        Utilidades.dibujar(result,carrosfp);
    }
    

    
//    public void dibujarLista(DoublyCircularLinkedList<Vehiculo> carros)
//    {
//        Platform.runLater(() -> {
//            listHBox.getChildren().clear();
//        });
//        
//        //Verificamos que la lista no esté vacía
//        if(!carros.isEmpty())
//        {
//            //Problema: Nunca dibuja el vehículo con índice last
//            //Recorremos los elementos para poder obtener las imágenes
//            for(DoublyCircularNodeList<Vehiculo> v = carros.getLast().getNext();v != carros.getLast(); v = v.getNext())
//            {
//                ImageView im = new ImageView("imgs/"+v.getcontent().getFotos().getLast().getNext().getcontent().toString());
//                //Cada imagen tendrá un manejador para que al darle click nos muestre la información del carro
//                im.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent t) -> { 
//                    Platform.runLater(() -> {
//                        verCarro(im,t.getSource().toString());
//                        Button b1 = new Button("Regresar");
//                        b1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t1) -> {dibujarLista(carros);});
//                        detailVBox.getChildren().addAll(b1);
//                    });
//                });
//                listHBox.getChildren().addAll(im);
//                System.out.println("HOLAAAAAAAAAAA");
//                listHBox.getChildren().addAll(new Label("holaaa"));
//
//            }
//        }
//        else
//        {
//            Label l = new Label("No existen vehículos");
//            l.setTextFill(Paint.valueOf("Black"));
//            l.setPrefSize(500, 500);
//            Platform.runLater(() -> {
//                listHBox.getChildren().addAll(l);
//            });
//        }
//    }
    
    //Este método nos permite ver un carro específico
//    public void verCarro(ImageView im,String s)
//    {
//        Platform.runLater(() -> {
//            listHBox.getChildren().clear();
//            listHBox.getChildren().addAll(im);
//
//            detailVBox.getChildren().clear();
//            Label l1 = new Label("Detalle");
//            detailVBox.getChildren().addAll(l1);
//
//            //A partir del nombre de la imagen encontramos el vehículo que la contiene
//            for(DoublyCircularNodeList<Vehiculo> v = carros.getLast().getNext();v != carros.getLast(); v = v.getNext())
//            {
//                if(v.getcontent().getFotos().getLast().getNext().equals(s))
//                {
//                    TextField td = new TextField(v.getcontent().getFotos().getLast().getNext().getcontent().toString());
//                    detailVBox.getChildren().addAll(td);
//                }
//            }
//        });
//    }

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

            Stage currentStage = (Stage) cvautos.getScene().getWindow();
            currentStage.close();
    }
    
    
}
