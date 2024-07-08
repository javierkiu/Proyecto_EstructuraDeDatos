/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_estructuradedatos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private Label labeluser;
    @FXML
    private ImageView imgviewuser;
    @FXML
    private Label searchTxt1;
    @FXML
    private ComboBox<?> cvautos;
    @FXML
    private ComboBox<?> cvmarcas;
    @FXML
    private ComboBox<?> cvpreciosdesde;
    @FXML
    private ComboBox<?> cvprecioshasta;
    @FXML
    private ComboBox<?> cvañosdesde;
    @FXML
    private ComboBox<?> cvañoshasta;

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
    private Button buyBtt;
    @FXML
    private Button sellBtt;
    @FXML
    private Label searchTxt;
    private ComboBox<String> carFilter;
    private HBox listHBox;
    @FXML
    private VBox detailVBox;
    
    
    private ArrayList<Vehiculo> carros;     
    private DoublyCircularLinkedList<Vehiculo> listaVenta;
    @FXML
    private FlowPane carrosfp;
    
    
    public void initializeData(String user){
        Usuario us = Utilidades.obtenerDatosUsuario(user);
        labeluser.setText(us.getNombre() + " " + us.getApellido());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgviewuser.setImage(new Image("imgs/user.png"));
        carros= Utilidades.leer();
        
        listaVenta = new DoublyCircularLinkedList<>();
        
        dibujar(carros);
    }    

    @FXML
    private void filtrar(ActionEvent event) {
        String cat = carFilter.getValue();
        
        if(cat.equals("Filtro"))
            //Muestra los carros en el orden de instanciación
            dibujar(carros);
        else
        {
            //Usando un comparador para modificar el orden de la lista carros
        }
    }
    
    public boolean dibujar(ArrayList<Vehiculo> carros){
        if(carros.isEmpty()) return false;
        VBox vb;
        ImageView iv;
        Label lb1; 
        Label lb2;
        String st1;
        String st2;

        for(Vehiculo v : carros){
            System.out.println("imgs/"+v.getFotos().getLast().getcontent()+".jpg");
            vb = new VBox();
            iv = new ImageView(new Image("imgs/"+v.getFotos().getLast().getcontent()+".jpg"));
            st1 = v.getMarca().getNombre() + " " + v.getModelo();
            lb1 = new Label(st1.toUpperCase());
            lb1.setStyle("-fx-font-weight: bold;");
           
            st2 = Double.toString(v.getPrecio()) + "$";
            lb2 = new Label(st2);
            lb2.setStyle("-fx-font-weight: bold;");

            System.out.println(iv.getImage().getUrl());
            iv.setFitHeight(150);
            iv.setFitWidth(225);
            Insets margin = new Insets(10, 20, 10, 20);
            carrosfp.setMargin(vb,margin);
            vb.setMargin(lb1,new Insets(10,0,10,5));
            vb.setMargin(lb2,new Insets(10,0,10,5));
            vb.setStyle("-fx-border-color: gray; -fx-border-width: 0.5px; -fx-border-style: solid;");
            vb.getChildren().addAll(iv, lb1,lb2);
            carrosfp.getChildren().add(vb);     
        }
        return true;
    }
    
//    public boolean dibujar(DoublyCircularLinkedList<Vehiculo> carros){
//        if(carros.isEmpty()) return false;
//        DoublyCircularNodeList<Vehiculo> nd= carros.getLast().getNext();
//        HBox hb;
//        ImageView iv;
//        do{
//            hb = new HBox();
//            iv = new ImageView(new Image(nd.getcontent().getFotos().getLast().getcontent()));
//            iv.setFitHeight(50);
//            iv.setFitWidth(60);
//            hb.getChildren().add(iv);
//            listHBox.getChildren().add(hb);
//        }while(nd!=carros.getLast().getNext());
//        
//        return true;
//    }
    
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
    
    
}
