package ciclosbbddopcional;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    private  static final String url= "jdbc:mysql://localhost:3306/ciclos"; //base de datos
    
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
    
    //crear tabla
    public void crearTabla(String ciclo) throws SQLException {
        
        Statement st = null;
        
        try {
            st = conn.createStatement();
            
            //metemos todo el código en un string
            /*Normalmente en bases de datos los nombres de las tablas y los nombres de las columnas no llevan espacios 
            porque esto genera problemas. En el caso de querer usar nombres con espacios 
            (no recomendado) puedes intentar encerrar el nombre con espacio con comilla invertida 
            o comilla simple para que lo considere en conjunto.
            En este caso usaremos nombres como Desarrollo_web*/
            String sql =
                    "CREATE TABLE " + ciclo +  " (" +
                "       id         VARCHAR(10) PRIMARY KEY," +
                "       modulo       TEXT,              " +
                "       horas INT(10))";
                
            st.executeUpdate(sql); //ejecutamos la string
            System.out.println("Creada la tabla " + ciclo);
        } finally {
            if (st != null) { st.close(); }
        }
    }
    
     public void eliminaTabla(String ciclo) throws SQLException {
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS " + ciclo + ""; //borramos el ciclo introduciso
            st.executeUpdate (sql);
            System.out.println("Eliminado el ciclo " + ciclo);
        } finally {
            if (st != null) { st.close(); }
        }
    }
     
     //eliminar modulo
     public void eliminaModulo(String ciclo, String mod) throws SQLException {
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql = "DELETE FROM " + ciclo + " WHERE id='" + mod + "'"; //borramos el registro cual d sea igual al introducido
            st.executeUpdate (sql);
            System.out.println("Eliminado módulo " + mod + " del ciclo " + ciclo);
        } finally {
            if (st != null) { st.close(); }
        }
    }
   
     //insertamos
    public void anadirModulo( String ciclo, String mod, String nomModu, int h) throws SQLException {
        // metemos en un string
        
        String p="pedidos";
        String sql = "INSERT INTO " + p + " (id, modulo , horas) values ('"
            + ""+ mod +""
            + "', '"
            + ""+ nomModu +""
            + "', '"
            + ""+ h +""
            + "')";
       
        Statement st = null;
        try {
            st = conn.createStatement();
            int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("Numero de módulos agregados: " + num);
            
            
        } finally {
            if (st != null) { st.close(); }
        }
    }


   
    public void mostrarCiclos() throws SQLException {
        String sql = "SHOW TABLES";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int nCiclos = 0;
            while (rs.next()) {
                
                String nom = rs.getString("Tables_in_ciclos");
             
                System.out.println(nom);
                nCiclos++;
            }
            if (nCiclos==0) System.out.println("Ningún ciclo por el momento");
            rs.close();
        } finally {
            if (st != null) { st.close(); }
        }
    }
    
    public void editarModulo(String ciclo, String mod, String mod2, String nomModu, int h) throws SQLException {
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql = "UPDATE " + ciclo + " SET id='"+ mod2 +"', modulo='" + nomModu +"', horas='" + h +"' WHERE id='"+ mod + "'"; //actualizamos el registro
            st.executeUpdate (sql);
            System.out.println("Actualizado el módulo " + mod + " del ciclo " + ciclo);
        } finally {
            if (st != null) { st.close(); }
        }
    }
   
}
