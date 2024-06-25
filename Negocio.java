/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Steven Morocho
 */
public class Negocio {
    private LinkedList<Auto> autosEnVenta;
    public Negocio(){
        autosEnVenta=new LinkedList();
    }
    public void agregarAuto(Auto a){
        autosEnVenta.addFirst(a);
    }
    public void mostrarAutos(){
        while(!autosEnVenta.isEmpty())
            for(Auto a:autosEnVenta){
                System.out.println(a);
            }
    }
    public List<Auto> buscarPorMarca(String marca) {
        List<Auto> resultado = new LinkedList<>();
        for (Auto auto : autosEnVenta) {
            if (auto.getMarca().equalsIgnoreCase(marca)) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    public List<Auto> buscarPorModelo(String modelo) {
        List<Auto> resultado = new LinkedList<>();
        for (Auto auto : autosEnVenta) {
            if (auto.getModelo().equalsIgnoreCase(modelo)) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    public List<Auto> buscarPorRangoDePrecio(int precioMin, int precioMax) {
        List<Auto> resultado = new LinkedList<>();
        for (Auto auto : autosEnVenta) {
            if (auto.getPrecio() >= precioMin && auto.getPrecio() <= precioMax) {
                resultado.addFirst(auto);
            }
        }
        return resultado;
    }
    public List<Auto> filtrarPorAccidentesGravedad(String gravedad) {
        List<Auto> resultado = new LinkedList<>();
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
    public List<Auto> filtrarPorAccidentesAño(int año) {
        List<Auto> resultado = new LinkedList<>();
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
    public List<Auto> filtrarPorMantenimientosAño(int año) {
        List<Auto> resultado = new LinkedList<>();
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
            autosEnVenta = (LinkedList<Auto>) ois.readObject();
        }
    }
}
