/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.Serializable;
import java.util.Random;
import lists.*;
/**
 *
 * @author JAVIER
 */
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    private double precio;
    private Marca marca;
    private String modelo;
    private int año;
    private int kilometraje;
    private int ventas;
    private int motor;
    private String transmisión;
    private String peso;
    private String ubicacionActualVehiculo;
    private String estado;
    private String placa;
    private DoublyCircularLinkedList<String> fotos;
    private ArrayList<Accidente> accidentes;

    public Vehiculo(double precio, Marca marca, String modelo, int kilometraje, int ventas, int motor, String peso, String estado, String placa, int anio) {
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.ventas = ventas;
        this.motor = motor;
        this.peso = peso;
        this.estado = estado;
        this.placa = placa;
        this.fotos = new DoublyCircularLinkedList<>();
        this.accidentes = new ArrayList<>();
        this.año = anio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
    public void setMotor(int motor) {
        this.motor = motor;
    }
    public void setTransmisión(String transmisión) {
        this.transmisión = transmisión;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public void setUbicacionActualVehiculo(String ubicacionActualVehiculo) {
        this.ubicacionActualVehiculo = ubicacionActualVehiculo;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setFotos(DoublyCircularLinkedList<String> fotos) {
        this.fotos = fotos;
    }
    public void setAccidentes(ArrayList<Accidente> accidentes) {
        this.accidentes = accidentes;
    }

    public double getPrecio() {return precio;}
    public Marca getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public int getAño() {return año;}
    public int getKilometraje() {return kilometraje;}
    public int getVentas() {return ventas;}
    public int getMotor() {return motor;}
    public String getPeso() {return peso;}
    public String getUbicacionActualVehiculo() {return ubicacionActualVehiculo;}
    public String getEstado() {return estado;}
    public String getPlaca() {return placa;}
    public DoublyCircularLinkedList<String> getFotos() {return fotos;}
    public ArrayList<Accidente> getAccidentes() {return accidentes;}
    
    @Override
    public String toString() {
        return "Vehiculo{" + "precio=" + precio + ", marca=" + marca + ", modelo=" + modelo + ", a\u00f1o=" + año + ", kilometraje=" + kilometraje + ", ventas=" + ventas + ", placa=" + placa + '}';
    }
    
    

    
}
