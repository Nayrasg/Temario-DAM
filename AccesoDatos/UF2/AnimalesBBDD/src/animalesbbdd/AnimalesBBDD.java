/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalesbbdd;

/**
 *
 * @author Nayra
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class AnimalesBBDD {

 public static void main(String[] args) {
	        Conectar ua = null;
	        try {
	            ua = new Conectar();
	           ua.eliminaTabla();
	            ua.crearTabla();
	            ua.anyadeAnimal();
                    ua.consulta();
	        } catch(Exception e) {
	            e.printStackTrace();
	        } finally {
	            //if (ua != null) ua.desconnecta();
	        }
    }

    
    
}

