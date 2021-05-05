/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriabean;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nayra
 */
public class Conectar {
    
    //creamos la conexión
    private static Connection conn; 
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user ="root"; //usuario
    private static final String password = ""; //contraseña
    private  static final String url= "jdbc:mysql://localhost:3306/tienda"; //base de datos
    
    //constructor conectar
    public Conectar() {
        conn=null;
        try{
            Class.forName(driver);
            conn= (Connection) DriverManager.getConnection(url, user, password); //pasamos los datos definidos
            if(conn!=null){
                System.out.println("Conectado a la base de datos");}
        } catch (ClassNotFoundException | SQLException e){
                            System.out.println("Error al conectar"+e);

        }
    }
    
    //constructor para desconectar
    public void desconectar(){
        conn=null; //igualamos el objeto conn de conexion a null
    }
    
    public void mostrarProductos() throws SQLException {
        String sql = "SELECT * FROM productos;";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int nProductos = 0;
            while (rs.next()) {
                
                String nom = rs.getString("nombre");
             
                System.out.println(nom);
                nProductos++;
            }
            if (nProductos==0) System.out.println("Ningún ciclo por el momento");
            rs.close();
        } finally {
            if (st != null) { st.close(); }
        }
    }
    
    public void anadirPedido (int nomPro, int ct) throws SQLException {
        // metemos en un string
        String p="pedidos";
        String sql = "INSERT INTO " + p + " (producto , cantidad) values ('"
            + ""+ nomPro +""
            + "', '"
            + ""+ ct +""
            + "')";
        
        Statement st = null;
        try {
            st = conn.createStatement();
            int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("Numero de pedidos agregados: " + num);
            
            
        } finally {
            if (st != null) { st.close(); }
        }
    }
    
    public void editarProducto (int stock, int mod) throws SQLException {
        Statement st = null;
         String p="productos";
        try {
            st = conn.createStatement();
            String sql = "UPDATE " + p + " SET cantidad="+ stock +" WHERE id_producto='"+ mod + "'"; //actualizamos el registro
            st.executeUpdate (sql);
            System.out.println("Actualizado el producto " + mod);
        } finally {
            if (st != null) { st.close(); }
        }
    }
    
    public void anadirCompra (int nomPro, int ct) throws SQLException {
        // metemos en un string
        String p="pedidos";
        String sql = "INSERT INTO " + p + " (producto , cantidad) values ('"
            + ""+ nomPro +""
            + "', '"
            + ""+ ct +""
            + "')";
        
        Statement st = null;
        try {
            st = conn.createStatement();
            int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("Numero de pedidos agregados: " + num);
            
            
        } finally {
            if (st != null) { st.close(); }
        }
    }
    
}
