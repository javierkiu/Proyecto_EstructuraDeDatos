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
    private String color;
    private Queue<Accidente> accidentes;
    private Queue<Mantenimiento> mantenimientos;

    public Auto(String marca, String modelo, int precio, int año, double kilometraje, String ubicacion, double peso, String transmision, int motor, String foto, String color, Queue<Accidente> accidentes, Queue<Mantenimiento> mantenimientos) {
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
        this.color=color;
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
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void agregarAccidente(Accidente a){
        accidentes.offer(a);
    }
    
    public void agregarMantenimiento(Mantenimiento m){
        mantenimientos.offer(m);
    }

    //Comparacion por precios de menor a mayor
//    @Override
//    public int compareTo(Auto o) {
//        return Integer.compare(this.precio, o.precio);
//    }
//    Comparacion por precios de mayor a menor
//    @Override
//    public int compareTo(Auto o) {
//        return Integer.compare(o.precio, this.precio);
//    }
    
    // Comparacion por años de menor a mayor
//    @Override
//    public int compareTo(Auto o) {
//        return Integer.compare(this.año, o.año);
//    }
    // Comparacion por años de mayor a menor
//    @Override
//    public int compareTo(Auto o) {
//        return Integer.compare(o.año, this.año);
//    }
    
    //Comparacion kilometraje de menor a mayor
//    @Override
//    public int compareTo(Auto o) {
//        return Double.compare(this.kilometraje,o.kilometraje);
//    }
    //Comparacion kilometraje mayor a menor
//    @Override
//    public int compareTo(Auto o) {
//        return Double.compare(o.kilometraje,this.kilometraje);
//    }
    
    //Comparacion color
//    @Override
//    public int compareTo(Auto o) {
//        return this.color.compareToIgnoreCase(o.color);
//    }
    
    //Comparacion marca
//    @Override
//    public int compareTo(Auto o) {
//        return this.marca.compareToIgnoreCase(o.marca);
//    }
    
    //Comparacion modelo
//    @Override
//    public int compareTo(Auto o) {
//        return this.modelo.compareToIgnoreCase(o.modelo);
//    }
    
    //Comparacion peso de menor a mayor
//    @Override
//    public int compareTo(Auto o) {
//        return Double.compare(this.peso,o.peso);
//    }
    //Comparacion peso mayor a menor
    @Override
    public int compareTo(Auto o) {
        return Double.compare(o.peso,this.peso);
    }
}
