/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nayra
 */
public class Personas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        String nombre;
       
        FileWriter fi = null;
        PrintWriter pw = null;
        
        
         //creamos el fichero
        File fichero = new File ("personas.txt");//declaro fichero
        if (!fichero.exists()) {
    
            try {
                    // A partir del objeto File creamos el fichero físicamente
                    if (fichero.createNewFile())
                    {
                      System.out.println("El fichero se ha creado correctamente");
                        fi = new FileWriter(fichero); //al estar recien creado escribimos al principio
                    }
                    else
                      System.out.println("No ha podido ser creado el fichero");
             } catch (IOException ioe) {
                ioe.printStackTrace();
             }
        }else{
            
            System.out.println("El fichero ya existe");
            fi = new FileWriter(fichero,true); //como ya existe escribimos debajo de lo ya escrito
        }
        
            
            
            try{
                
                
                pw = new PrintWriter(fi);
      
                        do
                        {        
                                //Introducimos los datos
                               nombre = JOptionPane.showInputDialog(null,"Introduce el nombre");
                               
                               
                               if(nombre==null)
                               {
                                   
                                   //si damos a cancelar se cierra
                                   System.out.println("Dio Clic en Cancelar o Cerrar y no introdujo los datos...");
                                   break;

                                
                               }
                               else
                               {
                                   
                                    //pw.println(nombre);
                                    String apellidos = JOptionPane.showInputDialog(null, "Introduce los apellidos");
                                    
                                    if(apellidos==null)
                                    {
                                   
                                   //si damos a cancelar se cierra
                                            System.out.println("Dio Clic en Cancelar o Cerrar y no introdujo los datos...");
                                            break;

                                
                                     }
                                    else
                                    {
                                            //pw.println(apellidos);
                               

                                           String sexo = JOptionPane.showInputDialog(null, "Introduce el sexo");
                                           
                                            if(sexo==null)
                                            {
                                   
                                                    //si damos a cancelar se cierra
                                                    System.out.println("Dio Clic en Cancelar o Cerrar y no introdujo los datos...");
                                                    break;

                                
                                            }
                                            else
                                            {
                                 
                                                    // pw.println(sexo);

                                                    String texto = JOptionPane.showInputDialog(null, "Introduce la edad");
                                                    
                                                    if(texto==null)
                                                    {
                                   
                                                            //si damos a cancelar se cierra
                                                            System.out.println("Dio Clic en Cancelar o Cerrar y no introdujo los datos...");
                                                            break;

                                
                                                    }
                                                     else
                                                    {
                                                            int edad = Integer.parseInt(texto);
                                                            pw.println(nombre +" "+ apellidos + " " + sexo + " " + edad); //escribimos los datos en el documento
                                                    }
                                            }
                                    }
                                   

                                
                               
                               }
                              

                               
                        }while(nombre!=null); //se hace mientras no se de a cancelar o ombre sea null
                        
            } catch (Exception e) {
                    e.printStackTrace();
            } finally {
           
            try {
           // Aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fi)
              fi.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    }
    

