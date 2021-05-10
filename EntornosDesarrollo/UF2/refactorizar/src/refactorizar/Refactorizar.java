package refactorizar;

import refactorizar.operaciones.Operaciones;

/**
 *
 * @author Nayra
 */
public class Refactorizar {
    
     
    
    private static int x=5, y=3, result;

    public static void main(String[] args) {
        
        
       
        result=Operaciones.suma(x, y);
        showResult(result);
    }

    private static void showResult(int result) {
        System.out.println("El resultado es: ");
        System.out.println(result);
    }

    /**
     * @param aX the x to set
     */
    public static void setX(int aX) {
        x = aX;
    }

    /**
     * @param aY the y to set
     */
    public static void setY(int aY) {
        y = aY;
    }
       
    
}
