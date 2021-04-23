/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exepcion1;

/**
 *
 * @author Nayra
 */
public class Exepcion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int a=0;
        int b=0;
        try //envolvemos en un try catch para el tratamiento de errores
        {
            System.out.println(a/b);
        }catch (Exception e)
            {
             
                System.out.println("Error"); //en caso de error muestra
            }
            
            

    }
    
}
