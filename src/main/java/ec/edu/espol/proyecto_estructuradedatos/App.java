package ec.edu.espol.proyecto_estructuradedatos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lists.*;
import modelo.*;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Utilidades.escribirListaUsuarios(new ArrayList<Usuario>());
        Utilidades.generarVehiculos();
        scene = new Scene(loadFXML("primary"), 640, 580);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
//          Usuario us = new Usuario("Javier","Rodriguez","javierkiu","12345","javier@gmail.com");
//          Utilidades.registrarUsuario(us);
        launch();
//        DoublyCircularLinkedList dc = new DoublyCircularLinkedList();
//        dc.addLast(1);
//        dc.addLast(2);
//        dc.addLast(3);
//        dc.addLast(4);

    }

}