/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propiedades;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Nayra
 */
public class Propiedades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {

                Scanner out = new Scanner(System.in);

                String cadena;

                //pedimos la ruta del archivo
                //Hay que tener cudado en Windows porque no aceta carácteres especiales
                //Yo lo he probado con C:\Users\Nayra\Documents\hola.txt
                System.out.println("Introduce la ruta del archivo: "); 
                cadena = out.nextLine();
                /*remplazamos las diagolaes simples introducidas por el usuario por
                diagolaes doble para ue el fileReader lo pueda leer correctamente
                El doble backslash te permite hacer un escape de caractes especial 
                por lo cual para detectar cada slash necesitas uno que vaya detras de el. 
                El \\ equivale realmente a \.
                */
                cadena = cadena.replace("\\", "\\\\");
                BufferedReader br = new BufferedReader(new FileReader(cadena));  
                
                
                //abrmos fichero
                File archivo = new File(cadena);
                
                
                System.out.println("-----INFORMACIÖN DEL ARCHIVO-----");
                
                //obtenemos los datos
                System.out.println("Nombre: " +archivo.getName());
                System.out.println("Ruta: " +archivo.getPath());
                System.out.println("Ruta absoluta: " +archivo.getAbsolutePath());
                
                
                if (archivo.canRead())
                {
                    System.out.println("El archivo se puede leer");
                } else {
                    System.out.println("El archivo no se puede leer");
                }
                
                if (archivo.canWrite())
                {
                    System.out.println("El archivo tiene permiso de escritura");
                } else {
                    System.out.println("El archivo no tiene permiso de escritura");
                }
                
                System.out.println("Tamaño: " +archivo.length()+ " bytes");
                
                if (archivo.isDirectory())
                {
                    System.out.println("El archivo es un directorio");
                } else {
                    System.out.println("El archivo no es un directorio");
                }
                
                if (archivo.isFile())
                {
                    System.out.println("El archivo es un archivo");
                } else {
                    System.out.println("El archivo no es un archivo");
                }
                
                
                System.out.println("Nombre del padre: " +archivo.getParent());
                
                
        } catch (IOException ex ) {
            System.out.println("No se ha encontrado el archivo."); //en caso de error
        }
        
        
        
       
        
    }
    
}
