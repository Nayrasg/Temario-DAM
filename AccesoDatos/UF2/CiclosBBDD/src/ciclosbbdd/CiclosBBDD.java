/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclosbbdd;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Nayra
 */
public class CiclosBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        int opcion, h;
        String ciclo, mod, nomModu;
        
        Scanner teclado = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        
        Conectar conx = null;
        
        try {
	            conx = new Conectar();
	        } catch(Exception e) {
	            e.printStackTrace();
	        } finally {
	            //if (ua != null) ua.desconnecta();
	        }
        
        System.out.println("----------------MENÚ---------------");
        System.out.println("| 1. Crear ciclo formativo nuevo. |");
        System.out.println("| 2. Añadir módulo.               |");
        System.out.println("| 3. Borrar módulo.               |");
        System.out.println("| 4. Borrar ciclo formativo.      |");
        System.out.println("| 5. Listar ciclos formativos.    |");
        System.out.println("| 6. Salir.                       |");
        System.out.println("-----------------------------------");
         
        System.out.println("Introduzca una opción: ");
        opcion=teclado.nextInt();
        
        switch(opcion)
        {
            case 1:
                
                
                
                /*Normalmente en bases de datos los nombres de las tablas y los nombres de las columnas no llevan espacios 
            porque esto genera problemas. En el caso de querer usar nombres con espacios 
            (no recomendado) puedes intentar encerrar el nombre con espacio con comilla invertida 
            o comilla simple para que lo considere en conjunto.
            En este caso usaremos nombres como Desarrollo_web*/
                
                System.out.println("Introduzca el nombre del ciclo formativo: ");
                ciclo=sc.nextLine();
                conx.crearTabla(ciclo);
                break;
            case 2:
                
                System.out.println("Introduzca el nombre del ciclo formativo: ");
                ciclo=sc.nextLine();
                
                System.out.println("Introduzca el id del módulo: ");
                mod=sc.nextLine();
                
                System.out.println("Introduzca el nombre del módulo: ");
                nomModu=sc.nextLine();
                
                System.out.println("Introduzca las horas del módulo: ");
                h=teclado.nextInt();
                
                conx.anadirModulo(ciclo, mod, nomModu, h);
                break;
            case 3:
                
                System.out.println("Introduzca el nombre del ciclo formativo: ");
                ciclo=sc.nextLine();
                
                System.out.println("Introduzca el id del módulo a eliminar: ");
                mod=sc.nextLine();
                
                conx.eliminaModulo(ciclo, mod);
                break;
            case 4:
                
                System.out.println("Introduzca el nombre del ciclo formativo: ");
                ciclo=sc.nextLine();
                conx.eliminaTabla(ciclo);
                break;
            case 5:
                System.out.println("Los ciclos formativos del centro son: ");
                conx.mostrarCiclos();
                break;
            case 6:
                System.out.println("Ha salido.");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    
}
