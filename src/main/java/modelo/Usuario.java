/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JAVIER
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String mail;

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

    public Usuario(String usuario, String nombre, String apellido, String mail, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.mail = mail;
    }
    
    
    
}
