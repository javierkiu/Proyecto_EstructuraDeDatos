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
    private ArrayList<Auto> autosEnVenta;
    public Negocio(){
        autosEnVenta=new ArrayList();
    }
    public void agregarAuto(Auto a){
        autosEnVenta.addFirst(a);
    }

    public void setAutosEnVenta(ArrayList<Auto> autosEnVenta) {
        this.autosEnVenta = autosEnVenta;
    }
    
    public void mostrarAutos(){
        while(!autosEnVenta.isEmpty())
            for(Auto a:autosEnVenta){
                System.out.println(a);
            }
    }
    public ArrayList<Auto> buscarPorMarca(String marca) {
        ArrayList<Auto> resultado = new ArrayList<>();
        for (Auto auto : autosEnVenta) {
            if (auto.getMarca().equalsIgnoreCase(marca)) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    public ArrayList<Auto> buscarPorModelo(String modelo) {
        ArrayList<Auto> resultado = new ArrayList<>();
        for (Auto auto : autosEnVenta) {
            if (auto.getModelo().equalsIgnoreCase(modelo)) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    public ArrayList<Auto> buscarPorRangoDePrecio(int precioMin, int precioMax) {
        ArrayList<Auto> resultado = new ArrayList<>();
        for (Auto auto : autosEnVenta) {
            if (auto.getPrecio() >= precioMin && auto.getPrecio() <= precioMax) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    public ArrayList<Auto> filtrarPorAccidentesGravedad(String gravedad) {
        ArrayList<Auto> resultado = new ArrayList<>();
        for (Auto auto : autosEnVenta) {
            for (Accidente accidente : auto.getAccidentes()) {
                if (accidente.getGravedad().equalsIgnoreCase(gravedad)) {
                    resultado.addFirst(auto);
                    break;
                }
            }
        }
        return resultado;
    }
    public ArrayList<Auto> filtrarPorAccidentesAño(int año) {
        ArrayList<Auto> resultado = new ArrayList<>();
        for (Auto auto : autosEnVenta) {
            for (Accidente accidente : auto.getAccidentes()) {
                if (accidente.getAño()==año) {
                    resultado.addFirst(auto);
                    break;
                }
            }
        }
        return resultado;
    }
    public ArrayList<Auto> filtrarPorMantenimientosAño(int año) {
        ArrayList<Auto> resultado = new ArrayList<>();
        for (Auto auto : autosEnVenta) {
            for (Mantenimiento m : auto.getMantenimientos()) {
                if (m.getAño()==año) {
                    resultado.addFirst(auto);
                    break;
                }
            }
        }
        return resultado;
    }
    public void guardarDatos(String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(autosEnVenta);
        }
    }
    public void cargarDatos(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            autosEnVenta = (ArrayList<Auto>) ois.readObject();
        }
    }
}
