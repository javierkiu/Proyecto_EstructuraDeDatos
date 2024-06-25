/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import lists.*;
/**
 *
 * @author JAVIER
 */
public class Vehiculo {
    private double precio;
    private Marca marca;
    private String modelo;
    private int año;
    private int kilometraje;
    private int ventas;
    private String motor;
    private String transmisión;
    private String peso;
    private String ubicacionActualVehiculo;
    private String estado;
    private String placa;
    private DoublyCircularLinkedList<String> fotos;
    private ArrayList<String> accidentesOServicios;

    public double getPrecio() {
        return precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public int getVentas() {
        return ventas;
    }

    public String getMotor() {
        return motor;
    }

    public String getTransmisión() {
        return transmisión;
    }

    public String getPeso() {
        return peso;
    }

    public String getUbicacionActualVehiculo() {
        return ubicacionActualVehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public String getPlaca() {
        return placa;
    }

    public DoublyCircularLinkedList<String> getFotos() {
        return fotos;
    }

    public ArrayList<String> getAccidentesOServicios() {
        return accidentesOServicios;
    }
    
    
}
