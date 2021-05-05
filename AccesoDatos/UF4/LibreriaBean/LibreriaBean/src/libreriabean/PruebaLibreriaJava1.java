/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriabean;

import java.sql.SQLException;
import java.util.Scanner;

public class PruebaLibreriaJava1 {
   public static void main(String[] args) throws SQLException {
     //zapateria online
     
        int opcion, cant, cant2;
        int nuevo_stock=0;
     
        Scanner teclado = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        
        //conectamos con la bd
        Conectar conx = null;
        
        try {
	            conx = new Conectar();
	        } catch(Exception e) {
	            e.printStackTrace();
	        } finally {
	            //if (ua != null) ua.desconnecta();
	        }
        //listamos productos
        System.out.println("Los productos de la tienda son: ");
        conx.mostrarProductos();
        
        
         //Introduzco los  productos de mi tienda
         Producto producto1 = new Producto
                      (1, "Zapatillas nike", 3, 3, 100);//id, descripcion, stock, stockmin, pvp

         Producto producto2 = new Producto
                      (2, "Zapatillas Reebok", 5, 2, 90);//id, descripcion, stock, stockmin, pvp


         Producto producto3 = new Producto
                      (3, "Zapatillas Adidas", 15, 3, 120);//id, descripcion, stock, stockmin, pvp
         Producto producto4 = new Producto
                      (4, "Zapatillas Vans", 4, 3, 135);//id, descripcion, stock, stockmin, pvp
     
        
        System.out.println("----Producto que desea comprar:----");
        System.out.println("| 1. Zapatillas Nike              |");
        System.out.println("| 2. Zapatillas Reebook           |");
        System.out.println("| 3. Zapatillas Adidas.           |");
        System.out.println("| 4. Zapatilas Vans.              |");
        System.out.println("| 5. Salir.                       |");
        System.out.println("-----------------------------------");
         //pedimos al usuario que eliga un producto
        System.out.println("Introduzca una opción: ");
        opcion=teclado.nextInt();
        //cantidad
        System.out.println("Cantidad que desea: ");
        cant=teclado.nextInt();
         
     
        //Se realiza un pedido de unas zapatillas 
        Pedido pedido1 = new Pedido();
        
        switch(opcion)
        {
            case 1:
               
                pedido1.setProducto(producto1);
                producto1.addPropertyChangeListener(pedido1);//Aviso de que esta accion puede generar un cambio
                pedido1.setCantidad(1);
                nuevo_stock= producto1.getStockactual()- pedido1.getCantidad(); //Decremento el stock
                producto1.setStockactual(nuevo_stock); //cambiamos el stock

                System.out.printf("PEDIDO REALIZADO -->Compro: "+cant+" de "+pedido1.getProducto().getDescripcion()+"\n");
                
                conx.anadirPedido(opcion, cant);
                conx.editarProducto(nuevo_stock, opcion);
                if (nuevo_stock<pedido1.getProducto().getStockminimo())
                {
                       System.out.printf("Reponemos: "+pedido1.getProducto().getDescripcion()+"\n");
                       System.out.println("Cantidad que desea: ");
                       cant2=teclado.nextInt();
                       conx.anadirCompra(opcion, cant2);
                       
                }
                break;
            case 2:
                
                pedido1.setProducto(producto2);
                producto2.addPropertyChangeListener(pedido1);//Aviso de que esta accion puede generar un cambio
                pedido1.setCantidad(1);
                nuevo_stock= producto2.getStockactual()- cant; //Decremento el stock
                producto2.setStockactual(nuevo_stock); //cambiamos el stock

                System.out.printf("PEDIDO REALIZADO -->Compro: "+cant+" de "+pedido1.getProducto().getDescripcion()+"\n");
                
                conx.anadirPedido(opcion, cant);
                conx.editarProducto(nuevo_stock, opcion);
                if (nuevo_stock<pedido1.getProducto().getStockminimo())
                {
                       System.out.printf("Reponemos: "+pedido1.getProducto().getDescripcion()+"\n");
                       System.out.println("Cantidad que desea: ");
                       cant2=teclado.nextInt();
                       conx.anadirCompra(opcion, cant2);
                       
                }
                
                break;
            case 3:
                
                pedido1.setProducto(producto3);
                producto3.addPropertyChangeListener(pedido1);//Aviso de que esta accion puede generar un cambio
                pedido1.setCantidad(1);
                nuevo_stock= producto3.getStockactual()- cant; //Decremento el stock
                producto3.setStockactual(nuevo_stock); //cambiamos el stock

                System.out.printf("PEDIDO REALIZADO -->Compro: "+cant+" de "+pedido1.getProducto().getDescripcion()+"\n");
                
                conx.anadirPedido(opcion, cant);
                conx.editarProducto(nuevo_stock, opcion);
                
                if (nuevo_stock<pedido1.getProducto().getStockminimo())
                {
                       System.out.printf("Reponemos: "+pedido1.getProducto().getDescripcion()+"\n");
                       System.out.println("Cantidad que desea: ");
                       cant2=teclado.nextInt();
                       conx.anadirCompra(opcion, cant2);
                       
                }
                
                break;
            case 4:
                
                pedido1.setProducto(producto4);
                producto4.addPropertyChangeListener(pedido1);//Aviso de que esta accion puede generar un cambio
                pedido1.setCantidad(1);
                nuevo_stock= producto4.getStockactual()- cant; //Decremento el stock
                producto4.setStockactual(nuevo_stock); //cambiamos el stock

                System.out.printf("PEDIDO REALIZADO -->Compro: "+cant+" de "+pedido1.getProducto().getDescripcion()+"\n");
                
                conx.anadirPedido(opcion, cant);
                conx.editarProducto(nuevo_stock, opcion);
                if (nuevo_stock<pedido1.getProducto().getStockminimo())
                {
                       System.out.printf("Reponemos: "+pedido1.getProducto().getDescripcion()+"\n");
                       System.out.println("Cantidad que desea: ");
                       cant2=teclado.nextInt();
                       conx.anadirCompra(opcion, cant2);
                       
                }
               
                break;

            case 51:
                System.out.println("Ha salido.");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
     
         
         
  }
}

