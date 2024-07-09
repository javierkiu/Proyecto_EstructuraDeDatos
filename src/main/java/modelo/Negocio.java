/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lists.*;


/**
 *
 * @author Steven Morocho
 */
public class Negocio {
    private ArrayList<Vehiculo> autosEnVenta;
    public Negocio(){
        autosEnVenta=new ArrayList();
    }
    public void agregarAuto(Vehiculo a){
        autosEnVenta.addFirst(a);
    }

    public void setAutosEnVenta(ArrayList<Vehiculo> autosEnVenta) {
        this.autosEnVenta = autosEnVenta;
    }
    
    public void mostrarAutos(){
        while(!autosEnVenta.isEmpty())
            for(Vehiculo a:autosEnVenta){
                System.out.println(a);
            }
    }
    public ArrayList<Vehiculo> buscarPorMarca(String marca) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo auto : autosEnVenta) {
            if (auto.getMarca().equals(marca)) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    public ArrayList<Vehiculo> buscarPorModelo(String modelo) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo auto : autosEnVenta) {
            if (auto.getModelo().equalsIgnoreCase(modelo)) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    public ArrayList<Vehiculo> buscarPorRangoDePrecio(int precioMin, int precioMax) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo auto : autosEnVenta) {
            if (auto.getPrecio() >= precioMin && auto.getPrecio() <= precioMax) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    
    public ArrayList<Vehiculo> buscarPorRangoDeAños(int añoMin, int añoMax) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo auto : autosEnVenta) {
            if (auto.getAño() >= añoMin && auto.getAño() <= añoMax) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    
    public ArrayList<Vehiculo> filtrarPorAccidentesGravedad(String gravedad) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo auto : autosEnVenta) {
            for (Accidente accidente : auto.getAccidentes()) {
                if (accidente.getGravedad().equalsIgnoreCase(gravedad)) {
                    resultado.addFirst(auto);
                    break;
                }
            }
        }
        return resultado;
    }
    public ArrayList<Vehiculo> filtrarPorAccidentesAño(int año) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo auto : autosEnVenta) {
            for (Accidente accidente : auto.getAccidentes()) {
                if (accidente.getAño()==año) {
                    resultado.addFirst(auto);
                    break;
                }
            }
        }
        return resultado;
    }
//    public ArrayList<Vehiculo> filtrarPorMantenimientosAño(int año) {
//        ArrayList<Vehiculo> resultado = new ArrayList<>();
//        for (Vehiculo auto : autosEnVenta) {
//            for (Mantenimiento m : auto.getMantenimientos()) {
//                if (m.getAño()==año) {
//                    resultado.addFirst(auto);
//                    break;
//                }
//            }
//        }
//        return resultado;
//    }
    
    public void guardarDatos(String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(autosEnVenta);
        }
    }
    public void cargarDatos(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            autosEnVenta = (ArrayList<Vehiculo>) ois.readObject();
        }
    }
}
