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
import lists.*;

/**
 *
 * @author JAVIER
 */
public class Utilidades {
    public static boolean registrarUsuario(Usuario us){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("src/main/resources/files/users.txt",true))){
            String line = us.getUsuario() + "," + us.getNombre() + "," + us.getApellido() +"," +  us.getMail() + "," + us.getContrasena();
            bf.write(line);
            bf.newLine();
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
    public static ArrayList<String> obtenerIdentificadores(){
        ArrayList<String> result = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/files/users.txt"))){
            String line;
            while((line = bf.readLine())!=null){
                result.addLast(line.split(",")[0]);
                result.addLast(line.split(",")[3]);
           }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    
    public static Usuario obtenerDatosUsuario(String usuario){
        Usuario u;
        try(BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/files/users.txt"))){
            String line;
            while((line = bf.readLine())!=null){
                String[] sp = line.split(",");
                if(sp[0].equals(usuario)||sp[3].equals(usuario)){
                    return new Usuario(sp[0], sp[1],sp[2],sp[3],sp[4]);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        return null;
    }
}
