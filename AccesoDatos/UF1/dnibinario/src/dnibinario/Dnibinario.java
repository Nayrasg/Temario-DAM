/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnibinario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Nayra
 */
public class Dnibinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException, IOException {
        // TODO code application logic here
         Scanner out = new Scanner(System.in);
        Scanner op = new Scanner(System.in);
        
      
       
        Scanner entrada = null;
        
        String linea;
        int opcion, num=0;
        boolean contiene = false;
        FileWriter fw = null;
        BufferedWriter bw = null;

        File fichero = new File ("datospersonas.dat");//declaro fichero
        
        System.out.println("Elige una opción: "); 
        System.out.println("1. Buscar usuario. "); 
        System.out.println("2. Añadir usuario. "); 
        System.out.println("3. Salir. "); 
        opcion=out.nextInt(); //leemos la opcion
        
        
        switch (opcion)
        {
            case 1:
                System.out.println("Introduce el DNI: "); 
                String d=op.nextLine();
                entrada = new Scanner(fichero);////creamos un Scanner para leer el fichero

                
                                
                while (entrada.hasNextLine()) 
                { //mientras no se llegue al final del fichero
                        linea = entrada.nextLine();  //se lee una línea
                        if (linea.contains(d)) 
                        {   //si la línea contiene el texto buscado se muestra por pantalla         
                              while (num!=4) //leemos las 4 lineas siguientes
                              {
                                    System.out.println(linea);
                                    linea = entrada.nextLine();
                                    num++;
                              }
                              contiene = true;
                        }
                
                 }   
                if(!contiene)
                { //si el archivo no contienen el texto se muestra un mensaje indicándolo

                        System.out.println("DNI " +d + " no se ha encontrado en el archivo");
                }
                entrada.close();
                break;
            case 2:
                
                //Append - boolean si es true, entonces los datos se escribirán al final del archivo en lugar del comienzo.
                fw = new FileWriter(fichero.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);//escribimos en el archivo
                
                System.out.println("Introduce el DNI"); 
                String dn = op.nextLine();
                
                bw.write("DNI: " +dn); //esbribimos en el fichero destino
                bw.flush(); //guardamos los cambios del fichero
                bw.newLine(); //seguimos escribiendo en una nueva linea
                
                System.out.println("Introduce el nombre"); 
                String nombre = op.nextLine();
                bw.write("Nombre: " +nombre); //esbribimosen el fi chero destino
                bw.flush(); //guardamos los cambios del fichero
                bw.newLine(); //seguimos escribiendo en una nueva linea
                
                System.out.println("Introduce los apellidos"); 
                String apellidos = op.nextLine();
                bw.write("Apellidos: " +apellidos); //esbribimos en el fichero destino
                bw.flush(); //guardamos los cambios del fichero
                bw.newLine(); //seguimos escribiendo en una nueva linea
                
                System.out.println("Introduce la edad"); 
                String edad = op.nextLine();
                bw.write("Edad: " +edad); //esbribimos en el fichero destino
                bw.newLine(); //seguimos escribiendo en una nueva linea
                bw.flush(); //guardamos los cambios del fichero
                
              
                bw.close();
                
                fw.close();
                break;
                                
                             
            case 3:
                System.out.println("Hasta luego");
                break;
                
            default: 
                
                System.out.println("Opción no válida");
        }
    }

 }
    

