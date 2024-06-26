/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Queue;
import lists.*;

/**
 *
 * @author Steven Morocho
 */
public class Auto implements Serializable, Comparable<Auto>{
    private String marca;
    private String modelo;
    private int precio;
    private int año;
    private double kilometraje;
    private String ubicacion;
    private double peso;
    private String transmision;
    private int motor;
    private DoublyCircularLinkedList<String> fotos;    
    private String color;
    private Queue<Accidente> accidentes;
    private Queue<Mantenimiento> mantenimientos;

    public Auto(String marca, String modelo, int precio, int año, double kilometraje, String ubicacion, double peso, String transmision, int motor, DoublyCircularLinkedList<String> fotos, String color, Queue<Accidente> accidentes, Queue<Mantenimiento> mantenimientos) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.año = año;
        this.kilometraje = kilometraje;
        this.ubicacion = ubicacion;
        this.peso = peso;
        this.transmision = transmision;
        this.motor = motor;
        this.fotos = fotos;
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

    public DoublyCircularLinkedList<String> getFotos() {
        return fotos;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Queue<Accidente> getAccidentes() {
        return accidentes;
    }

    public Queue<Mantenimiento> getMantenimientos() {
        return mantenimientos;
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
