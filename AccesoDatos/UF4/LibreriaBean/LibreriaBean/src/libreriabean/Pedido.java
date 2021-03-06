/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriabean;

import java.beans.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * 
 */
public class Pedido implements Serializable, PropertyChangeListener {//bean receptor

    private int numeropedido;
    private Producto producto;
    private Date fecha;
    private int cantidad;
 

    public Pedido() {

    }

    public Pedido(int numeropedido, Producto producto,
            Date fecha, int cantidad) {
        this.numeropedido = numeropedido;
        this.producto = producto;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getNumeropedido() {
        return numeropedido;
    }

    public void setNumeropedido(int numeropedido) {
        this.numeropedido = numeropedido;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        
       //en caso de que se produzca un evento aqui procederé a actuar
        
        System.out.printf("SOY EL BEAN RECEPTOR E INFORMO: Se ha alacanzado el stock minimo. %n");

        System.out.printf("Stock anterior: %d%n", evt.getOldValue());
        System.out.printf("Stock actual: %d%n", evt.getNewValue());

        System.out.printf("SOY EL BEAN RECEPTOR Y ACTUO: Se procede a solicitar compra de material del producto: %s%n",
                producto.getDescripcion());

        //insertar COMPRA DE MATERIAL DEL PRODUCTO QUE HA SUPERADO EL STOCK              
    
    }

    

}
