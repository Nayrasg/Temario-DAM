/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalesbbdd;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jorgeperis
 */
public class Conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user ="root";
    private static final String password = "";
    private  static final String url= "jdbc:mysql://localhost:3306/animales";

    public Conectar() {
        conn=null;
        try{
            Class.forName(driver);
            conn= (Connection) DriverManager.getConnection(url, user, password);
            if(conn!=null){
                System.out.println("Conectado a la base de datos");}
        } catch (ClassNotFoundException | SQLException e){
                            System.out.println("Error al conectar"+e);

        }
    }
    
    public void desconectar(){
        conn=null;
    }

      
    

   public void crearTabla() throws SQLException {
        //eliminaTabla(); // eliminem si ja existia
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql =
                "CREATE TABLE  ANIMALS (" +
                "       id        SERIAL PRIMARY KEY," +
                "       nom       TEXT,              " +
                "       categoria VARCHAR(40))";
            st.executeUpdate(sql);
            System.out.println("Creada taula ANIMALS");
        } finally {
            if (st != null) { st.close(); }
        }
    }
    
   
   public void eliminaTabla() throws SQLException {
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS ANIMALS";
            st.executeUpdate (sql);
            System.out.println("Eliminada taula ANIMALS");
        } finally {
            if (st != null) { st.close(); }
        }
    }
   
    public void anyadeAnimal() throws SQLException {
        // crea la comanda
        String sql = "INSERT INTO ANIMALS (nom, categoria) values ('"
            + "canari"
            + "', '"
            + "ocell"
            + "')";
        // envia la comanda
        Statement st = null;
        try {
            st = conn.createStatement();
            int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("Nombre d'animals afegits: " + num);
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
                  // assignem l'id de l'animal
            System.out.println("Afegit l'animal " + 1);
            rs.close();
        } finally {
            if (st != null) { st.close(); }
        }
    }


   
    public void consulta() throws SQLException {
        String sql = "SELECT * FROM ANIMALS ORDER BY nom";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int nAnimals = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String cat = rs.getString("categoria");
                System.out.println("ID: "+id+" Categoria: "+cat+" Nombre: "+nom);
                nAnimals++;
            }
            if (nAnimals==0) System.out.println("Cap animal de moment");
            rs.close();
        } finally {
            if (st != null) { st.close(); }
        }
    }
   
   
   
   
    
    
}
