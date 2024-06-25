/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Steven Morocho
 */
public class Auto {
    private String marca;
    private String modelo;
    private int precio;
    private int año;
    private double kilometraje;
    private String ubicacion;
    private double peso;
    private String transmision;
    private int motor;
    private String foto;
    private Queue<Accidente> accidentes;
    private Queue<Mantenimiento> mantenimientos;

    public Auto(String marca, String modelo, int precio, int año, double kilometraje, String ubicacion, double peso, String transmision, int motor, String foto, Queue<Accidente> accidentes, Queue<Mantenimiento> mantenimientos) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.año = año;
        this.kilometraje = kilometraje;
        this.ubicacion = ubicacion;
        this.peso = peso;
        this.transmision = transmision;
        this.motor = motor;
        this.foto = foto;
        this.accidentes = accidentes;
        this.mantenimientos = mantenimientos;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPrecio() {
        return precio;
    }
    
    public void setPrecio(int precio) {
        this.precio=precio;
    }

    public int getAño() {
        return año;
    }

    public double getKilometraje() {
        return kilometraje;
    }
    
    public void setKilometraje(double kilometraje) {
        this.kilometraje=kilometraje;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion=ubicacion;
    }

    public double getPeso() {
        return peso;
    }

    public String getTransmision() {
        return transmision;
    }

    public int getMotor() {
        return motor;
    }

    public String getFoto() {
        return foto;
    }
    
    public void setFoto(String foto){
        this.foto=foto;
    }
    
    public void agregarAccidente(Accidente a){
        accidentes.offer(a);
    }
    
    public void agregarMantenimiento(Mantenimiento m){
        mantenimientos.offer(m);
    }
    
}
