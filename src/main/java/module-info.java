module ec.edu.espol.proyecto_estructuradedatos {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyecto_estructuradedatos to javafx.fxml;
    exports ec.edu.espol.proyecto_estructuradedatos;
}
