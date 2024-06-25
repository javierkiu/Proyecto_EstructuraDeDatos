/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto2;
import java.io.Serializable;
/**
 *
 * @author Steven Morocho
 */
public class Mantenimiento implements Comparable<Mantenimiento>, Serializable{
    private String descripcion;
    private int año;

    public Mantenimiento(String descripcion, int año) {
        this.descripcion = descripcion;
        this.año = año;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    // Orden menor a mayor
    @Override
    public int compareTo(Mantenimiento o) {
        return Integer.compare(this.getAño(), o.getAño());
    }
//    Orden de mayor a menor
//    @Override
//    public int compareTo(Accidente o) {
//        return Integer.compare(o.getAño(), this.getAño());
//    }
    @Override
    public String toString() {
        return "Mantenimiento{" + "descripcion=" + descripcion + ", a\u00f1o=" + año + '}';
    }
    
}
