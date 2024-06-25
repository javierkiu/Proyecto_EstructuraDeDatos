/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author JAVIER
 */
public class Utilidades {
    public static boolean registrarUsuario(Usuario us){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("src/main/resources/files/users.txt"))){
            String line = us.getUsuario() + "," + us.getNombre() + "," + us.getApellido() +"," +  us.getMail() + "," + us.getContrasena();
            bf.write(line);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public static boolean verificarUsuario(String usuario){
        try(BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/files/users.txt"))){
            String line;
            while((line = bf.readLine())!=null){
                String us = line.split(",")[0];
                if(usuario.toLowerCase().equals(us.toLowerCase())) return false;
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
