/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra_todo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Nayra
 */
public class Muestra_todo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        File fichero = new File ("personas.txt");//creamo objeto File con el fichero   
        FileReader fr = new FileReader(fichero); //leemos fichero
        BufferedReader br = new BufferedReader(fr);
            
            
            
        //Se crea un string con las palabras que deben ser omitidas, en este caso el sexo
        String[] ignorar = new String[]{"Mujer", "Hombre", "No Binario"};
            
            
            
        String line;
        while ((line = br.readLine()) != null) { // Se lee la siguiente línea del fichero
            for (String texto : ignorar) { // recorremos buscando una coincidecia con las palabras que deben ser omitidas
                if (line.contains(texto)) { // si se encuentra alguna coincidencia
                    line = line.replace(texto, ""); // se reemplaza por un espacio en blanco
                }
            }

            if (!line.isEmpty()) { // después de realizar la búsqueda, si la línea no está en blanco
                System.out.println(line); // se imprime la línea
            }
        }

        //cerramos
        br.close();
        fr.close();
    }
}
    

