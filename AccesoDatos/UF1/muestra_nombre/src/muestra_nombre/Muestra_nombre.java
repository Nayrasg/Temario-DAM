/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra_nombre;
import java.io.*;
import java.util.Scanner;


/**
 *
 * @author Nayra
 */
public class Muestra_nombre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
        
        File fichero = new File ("personas.txt");//creamo objeto File con el fichero
        
     
        Scanner sc=new Scanner(fichero);//leemos/recorremos el fichero pasado comoobjeto File
        String linea;

        while(sc.hasNext()) //hace mientas tengamos más datos
        {
            linea=sc.next(); //cogemos cada dato
            if(linea!=" ") //si el dato es diferente a espacio. El nombre va antes deorimer espacio
            {
                System.out.println(linea); //mostramos
                linea=sc.nextLine(); //cogemos la siguiente linea
            }
        }
           
    }
    
}
