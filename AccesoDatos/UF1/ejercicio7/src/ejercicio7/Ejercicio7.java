/*
 Crea fichero1 con texto puesto por ti.
Crea fichero2 con texto puesto por ti.
Crea una aplicación que pida la ruta de  fichero1 y fichero2 y  una ruta de destino(fichero3). Debes copiar el contenido de fichero1 y fichero2 en fichero3.

Ejemplo:

Fichero1.txt
Hola mundo
-------------------
Fichero2.txt
Adiós mundo
--------------------

Dame la ruta del fichero1: miruta/fichero1.txt
Dame la ruta del fichero2: miruta/fichero2.txt
Dame la ruta del fichero3: miruta/fichero3.txt


Fichero3.txt
Hola mundo
Adiós mundo

 */
package ejercicio7;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Nayra
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
        Scanner out = new Scanner(System.in);
       
        
       //                  FICHERO 1
       
        
       String cadena1;

        //pedimos la ruta del archivo
        //Hay que tener cudado en Windows porque no aceta carácteres especiales
        
        System.out.println("Introduce la ruta del archivo 1: "); 
        cadena1 = out.nextLine(); 
        /*remplazamos las diagolaes simples introducidas por el usuario por
        diagolaes doble para ue el fileReader lo pueda leer correctamente
        El doble backslash te permite hacer un escape de caractes especial 
        por lo cual para detectar cada slash necesitas uno que vaya detras de el. 
        El \\ equivale realmente a \.
        */
        cadena1 = cadena1.replace("\\", "\\\\");
        BufferedReader br = new BufferedReader(new FileReader(cadena1));  
                
                
        //abrmos fichero
        File archivo1 = new File(cadena1);

       //             FICHERO 2
        
        String cadena2;

        //pedimos la ruta del archivo
        //Hay que tener cudado en Windows porque no aceta carácteres especiales
        
        System.out.println("Introduce la ruta del archivo 2: "); 
        cadena2 = out.nextLine(); 
        /*remplazamos las diagolaes simples introducidas por el usuario por
        diagolaes doble para ue el fileReader lo pueda leer correctamente
        El doble backslash te permite hacer un escape de caractes especial 
        por lo cual para detectar cada slash necesitas uno que vaya detras de el. 
        El \\ equivale realmente a \.
        */
        cadena2 = cadena2.replace("\\", "\\\\");
        //BufferedReader pr = new BufferedReader(new FileReader(cadena2));  
                
                
        //abrmos fichero
        File archivo2 = new File(cadena2);
        
        //  FICHERO 3
        
        String cadena3;

        //pedimos la ruta del archivo
        //Hay que tener cudado en Windows porque no aceta carácteres especiales
        
        System.out.println("Introduce la ruta del archivo 3: "); 
        cadena3 = out.nextLine(); 
        /*remplazamos las diagolaes simples introducidas por el usuario por
        diagolaes doble para ue el fileReader lo pueda leer correctamente
        El doble backslash te permite hacer un escape de caractes especial 
        por lo cual para detectar cada slash necesitas uno que vaya detras de el. 
        El \\ equivale realmente a \.
        */
        cadena3 = cadena3.replace("\\", "\\\\");
        
                
                
        //abrmos fichero
        File archivo3 = new File(cadena3);
        
        if (!archivo3.exists()) {
    
            try {
                        //Leemos ficheros
                    BufferedReader br1=new BufferedReader(new FileReader(archivo1));
                    BufferedReader br2=new BufferedReader(new FileReader(archivo2));
                    // A partir del objeto File creamos el fichero físicamente
                    if (archivo3.createNewFile())
                    {
                        System.out.println("El fichero se ha creado correctamente");
                         
                        //preparamos para escribiren el fichero 
                        BufferedWriter bw=new BufferedWriter(new FileWriter(archivo3));
                         
                        String linea=br1.readLine();//leemos
                        String linea2=br2.readLine();
                       
                        //mientras nosea el final del fichero
                        while(linea!=null){

                                bw.write(linea); //esbribimosen el fichero destino
                                bw.newLine(); //seguimos escribiendo en una nueva linea
                                bw.flush(); //guardamos los cambios del fichero
                                linea=br1.readLine();
                        }
                         //hacemos lo mismo para el segundo fichero
                         while(linea2!=null){
 
                                bw.write(linea2);
                                bw.flush();
 
                                linea2=br2.readLine();
            
                           }
                    }
                    else
                      System.out.println("No ha podido ser creado el fichero");
             } catch (IOException ioe) {
                ioe.printStackTrace();
             }
        }else{
            
            System.out.println("El fichero ya existe");
            //fi = new FileWriter(archivo3,true); //como ya existe escribimos debajo de lo ya escrito
        }

    }
    
}
    

