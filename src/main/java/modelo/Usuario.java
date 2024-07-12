/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import lists.ArrayList;

/**
 *
 * @author JAVIER
 */
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String mail;
    private ArrayList<Vehiculo> enVenta;
    private ArrayList<Vehiculo> favoritos;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getMail() {
        return mail;
    }

    public ArrayList<Vehiculo> getEnVenta() {
        return enVenta;
    }

    public ArrayList<Vehiculo> getFavoritos() {
        return favoritos;
    }
    

    public Usuario(String usuario, String nombre, String apellido, String mail, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.mail = mail;
        this.enVenta = new ArrayList<>();
        this.favoritos = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.mail, other.mail);
    }
    
    
    
}
