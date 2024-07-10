/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import lists.*;

/**
 *
 * @author JAVIER
 */
public class Utilidades {
    public static void escribirListaUsuarios(ArrayList<Usuario> usuarios){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.ser"))){
            oos.writeObject(usuarios);
        }catch(IOException e){
            e.printStackTrace();
        };    
    }
    
    public static boolean registrarUsuario(Usuario us){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("src/main/resources/files/users.txt",true))){
            String line = us.getUsuario() + "," + us.getNombre() + "," + us.getApellido() +"," +  us.getMail() + "," + us.getContrasena();
            bf.write(line);
            bf.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.ser"))){
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) ois.readObject();
            usuarios.addLast(us);
            Utilidades.escribirListaUsuarios(usuarios);
        }catch(IOException e){
            
        } catch (ClassNotFoundException ex) {
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
    
    public static String generarPlaca(){
        StringBuilder str = new StringBuilder();
        Random rd = new Random();
        String[] letras = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        str.append(letras[rd.nextInt(letras.length)]);
        str.append(letras[rd.nextInt(letras.length)]);
        str.append(letras[rd.nextInt(letras.length)]);
        
        str.append("-");
        
        str.append(rd.nextInt(10));
        str.append(rd.nextInt(10));
        str.append(rd.nextInt(10));

        return str.toString();
    }
    
    public static Vehiculo subirImgs(int cantidad, Vehiculo v){
        String marca = v.getMarca().getNombre();
        String modelo = v.getModelo();
        Vehiculo vb = v;
        for (int i = cantidad; i > 0; i--) {
            String url = marca+"_"+modelo+"_"+i;
            vb.getFotos().addLast(url);
        }
        return vb;
    }
    
    public static ArrayList<Vehiculo> leer (){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vehiculos.ser"))) {
            ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) ois.readObject();
            return vehiculos;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void generarVehiculos(){
        ArrayList<Vehiculo> result = new ArrayList<>();
        
        Marca chevrolet = new Marca("chevrolet", "chevrolet.png");
        Marca ducati = new Marca("ducati", "ducati.png");
        Marca hyundai = new Marca("hyundai", "hyundai.png");
        Marca honda = new Marca("honda", "honda.png");
        Marca kawasaki = new Marca("kawasaki", "kawasaki.png");
        Marca renault = new Marca("renault", "renault.png");
        Marca suzuki = new Marca("suzuki", "suzuki.png");
        Marca toyota = new Marca("toyota", "toyota.png");
        Marca yamaha = new Marca("yamaha", "yamaha.png");

        Vehiculo vb1 = new Vehiculo(4500, chevrolet, "aveo", 12000, 500, 1400, "ligero", "usado", Utilidades.generarPlaca(), 2010);
        vb1 = Utilidades.subirImgs(4, vb1);

        Vehiculo vb2 = new Vehiculo(5500, chevrolet, "groove", 8000, 600, 1600, "ligero", "usado", Utilidades.generarPlaca(), 2012);
        vb2 = Utilidades.subirImgs(4, vb2);
        
        Vehiculo vb3 = new Vehiculo(3000, chevrolet, "spark", 15000, 700, 1200, "ligero", "usado", Utilidades.generarPlaca(), 2015);
        vb3 = Utilidades.subirImgs(4, vb3);
     
        Vehiculo vb4 = new Vehiculo(3500, chevrolet, "vivant", 20000, 400, 1500, "ligero", "usado", Utilidades.generarPlaca(), 2008);
        vb4 = Utilidades.subirImgs(4, vb4);

        Vehiculo vb5 = new Vehiculo(3200, renault, "taliant", 0, 300, 1300, "ligero", "nuevo", Utilidades.generarPlaca(), 2023);
        vb5 = Utilidades.subirImgs(4, vb5);
        
        Vehiculo vb6 = new Vehiculo(3400, renault, "sandero", 0, 350, 1400, "ligero", "nuevo", Utilidades.generarPlaca(), 2023);
        vb6 = Utilidades.subirImgs(4, vb6);
        
        Vehiculo vb7 = new Vehiculo(3100, renault, "kwid", 0, 250, 1100, "ligero", "nuevo", Utilidades.generarPlaca(), 2023);
        vb7= Utilidades.subirImgs(4, vb7);
        
        Vehiculo vb8 = new Vehiculo(3300, renault, "logan", 0, 320, 1450, "ligero", "nuevo", Utilidades.generarPlaca(), 2023);
        vb8 = Utilidades.subirImgs(4, vb8);
        
        Vehiculo vb9 = new Vehiculo(7000, hyundai, "sonata", 22000, 600, 1700, "ligero", "usado", Utilidades.generarPlaca(), 2018);
        vb9 = Utilidades.subirImgs(4, vb9);
        
        Vehiculo vb10 = new Vehiculo(4200, hyundai, "accent", 15000, 450, 1600, "ligero", "usado", Utilidades.generarPlaca(), 2016);
        vb10 = Utilidades.subirImgs(4, vb10);
        
        Vehiculo vb11 = new Vehiculo(6800, hyundai, "tucson", 18000, 500, 1800, "ligero", "usado", Utilidades.generarPlaca(), 2019);
        vb11 = Utilidades.subirImgs(4, vb11);
        
        Vehiculo vb12 = new Vehiculo(5200, hyundai, "creta", 14000, 400, 1750, "ligero", "usado", Utilidades.generarPlaca(), 2017);
        vb12 = Utilidades.subirImgs(4, vb12);
        
        Vehiculo vb13 = new Vehiculo(8500, toyota, "camry", 30000, 700, 1600, "ligero", "usado", Utilidades.generarPlaca(), 2020);
        vb13 = Utilidades.subirImgs(4, vb13);
        
        Vehiculo vb14 = new Vehiculo(9500, toyota, "fortuner", 35000, 750, 1900, "ligero", "usado", Utilidades.generarPlaca(), 2021);
        vb14 = Utilidades.subirImgs(2, vb14);
        
        Vehiculo vb15 = new Vehiculo(12000, honda, "cbr600rr", 0, 200, 200, "motocicleta", "nuevo", Utilidades.generarPlaca(), 2023);
        vb15 = Utilidades.subirImgs(2, vb15);
        
        Vehiculo vb16 = new Vehiculo(11000, yamaha, "yzfr7", 0, 220, 210, "motocicleta", "nuevo", Utilidades.generarPlaca(), 2023);
        vb16 = Utilidades.subirImgs(2, vb16);
        
        Vehiculo vb17 = new Vehiculo(11500, kawasaki, "ninjazx6r", 0, 250, 220, "motocicleta", "nuevo", Utilidades.generarPlaca(), 2023);
        vb17 = Utilidades.subirImgs(2, vb17);
        
        Vehiculo vb18 = new Vehiculo(13000, ducati, "panigalev2", 0, 280, 230, "motocicleta", "nuevo", Utilidades.generarPlaca(), 2023);
        vb18 = Utilidades.subirImgs(2, vb18);
        
        Vehiculo vb19 = new Vehiculo(12500, suzuki, "gsxr1000", 0, 260, 240, "motocicleta", "nuevo", Utilidades.generarPlaca(), 2023);
        vb19 = Utilidades.subirImgs(2, vb19);

        
        result.addLast(vb1);
        result.addLast(vb2);
        result.addLast(vb3);
        result.addLast(vb4);
        result.addLast(vb5);
        result.addLast(vb6);
        result.addLast(vb7);
        result.addLast(vb8);
        result.addLast(vb9);
        result.addLast(vb10);
        result.addLast(vb11);
        result.addLast(vb12);
        result.addLast(vb13);
        result.addLast(vb14);
        result.addLast(vb15);
        result.addLast(vb16);
        result.addLast(vb17);
        result.addLast(vb18);
        result.addLast(vb19);
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vehiculos.ser"))){
            oos.writeObject(result);
        }catch(IOException e){
            e.printStackTrace();
        };
        
    }
    
}
