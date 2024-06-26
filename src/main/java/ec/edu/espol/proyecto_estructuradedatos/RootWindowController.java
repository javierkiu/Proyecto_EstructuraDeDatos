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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import lists.DoublyCircularLinkedList;
import lists.DoublyCircularNodeList;
import lists.DoublyLinkedList;
import modelo.Vehiculo;

/**
 * FXML Controller class
 *
 * @author levin
 */
public class RootWindowController implements Initializable {

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
    private ScrollPane carMenu;
    @FXML
    private Label searchTxt;
    @FXML
    private ComboBox<String> carFilter;
    @FXML
    private HBox listHBox;
    
    private DoublyCircularLinkedList<Vehiculo> carros;
    
    private DoublyCircularLinkedList<Vehiculo> listaVenta;
    
    @FXML
    private VBox detailVBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        carros = new DoublyCircularLinkedList<>();
        listaVenta = new DoublyCircularLinkedList<>();
        
        //Se llena la lista de carros
        
        dibujarLista(carros);
        
        // TODO
    }    

    @FXML
    private void filtrar(ActionEvent event) {
        String cat = carFilter.getValue();
        
        if(cat.equals("Filtro"))
            //Muestra los carros en el orden de instanciación
            dibujarLista(carros);
        else
        {
            //Usando un comparador para modificar el orden de la lista carros
        }
    }
    
    
    public void dibujarLista(DoublyCircularLinkedList<Vehiculo> carros)
    {
        Platform.runLater(() -> {
            listHBox.getChildren().clear();
        });
        
        //Verificamos que la lista no esté vacía
        if(!carros.isEmpty())
        {
            //Problema: Nunca dibuja el vehículo con índice last
            //Recorremos los elementos para poder obtener las imágenes
            for(DoublyCircularNodeList<Vehiculo> v = carros.getLast().getNext();v != carros.getLast(); v = v.getNext())
            {
                ImageView im = new ImageView("img/"+v.getcontent().getFotos().getLast().getNext().getcontent().toString());
                //Cada imagen tendrá un manejador para que al darle click nos muestre la información del carro
                im.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent t) -> { 
                    Platform.runLater(() -> {
                        verCarro(im,t.getSource().toString());
                        Button b1 = new Button("Regresar");
                        b1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t1) -> {dibujarLista(carros);});
                        detailVBox.getChildren().addAll(b1);
                    });
                });
                listHBox.getChildren().addAll(im);
            }
        }
        else
        {
            Label l = new Label("No existen vehículos");
            l.setTextFill(Paint.valueOf("Black"));
            l.setPrefSize(500, 500);
            Platform.runLater(() -> {
                listHBox.getChildren().addAll(l);
            });
        }
    }
    
    //Este método nos permite ver un carro específico
    public void verCarro(ImageView im,String s)
    {
        Platform.runLater(() -> {
            listHBox.getChildren().clear();
            listHBox.getChildren().addAll(im);

            detailVBox.getChildren().clear();
            Label l1 = new Label("Detalle");
            detailVBox.getChildren().addAll(l1);

            //A partir del nombre de la imagen encontramos el vehículo que la contiene
            for(DoublyCircularNodeList<Vehiculo> v = carros.getLast().getNext();v != carros.getLast(); v = v.getNext())
            {
                if(v.getcontent().getFotos().getLast().getNext().equals(s))
                {
                    TextField td = new TextField(v.getcontent().getFotos().getLast().getNext().getcontent().toString());
                    detailVBox.getChildren().addAll(td);
                }
            }
        });
    }
    
    
}
