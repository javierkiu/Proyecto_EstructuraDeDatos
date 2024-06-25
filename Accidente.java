/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto2;

import java.util.Objects;

/**
 *
 * @author Steven Morocho
 */
public class Accidente implements Comparable<Accidente>{
    private String descripcion;
    private int año;
    private String gravedad;

    public Accidente(String descripcion, int año, String gravedad) {
        this.descripcion = descripcion;
        this.año = año;
        this.gravedad=gravedad;
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

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accidente other = (Accidente) obj;
        if (this.año != other.año) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.gravedad, other.gravedad);
    }
    

    //Orden de menor a mayor
//    @Override
//    public int compareTo(Accidente o) {
//        return Integer.compare(this.getAño(), o.getAño());
//    }
    
//    Orden de mayor a menor
//    @Override
//    public int compareTo(Accidente o) {
//        return Integer.compare(o.getAño(), this.getAño());
//    }
    @Override
    public int compareTo(Accidente o) {
        if(this.gravedad.equals(o.gravedad))
            return 0;
        else if(this.gravedad.equals("Alta")&&(o.gravedad.equals("Media")||o.gravedad.equals("Baja")))
            return 1;
        else if(this.gravedad.equals("Media")&&(o.gravedad.equals("Baja")))
            return 1;
        else if(o.gravedad.equals("Alta")&&(this.gravedad.equals("Media")||this.gravedad.equals("Baja")))
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Accidente{" + "descripcion=" + descripcion + ", a\u00f1o=" + año + ", gravedad=" + gravedad + '}';
    }
    
}
