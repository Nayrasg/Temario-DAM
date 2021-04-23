/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exepciones2;

/**
 *
 * @author Nayra
 */
public class Exepciones2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
            int[] array =new int[5];
            try //envolvemos en un try catch para el tratamiento de errores
            {
                array[5]=1;
            }catch (Exception e)
            {
             
                System.out.println("Error"); //en caso de error muestra
            }


    }
    
}
