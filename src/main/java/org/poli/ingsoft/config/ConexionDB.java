package org.poli.ingsoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private static ConexionDB conexionDBInstance;
    private Connection connection;
    private final String URL= "jdbc:postgresql://localhost:5432/recursos_humanos";
    private final String USER = "postgres";
    private final String PASS = "admin";

    private ConexionDB() {
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado");
        }catch (Exception e){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            System.out.println("OK!");
        }
    }

    //Implementación del patrón singleton para acceder a una instancia única de la clase
    public static ConexionDB getInstance(){
        if (conexionDBInstance == null) {
            conexionDBInstance = new ConexionDB();
        }
        return conexionDBInstance;
    }

    public Connection getConnection() {
        return connection;
    }
}
