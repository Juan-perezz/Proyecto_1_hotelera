package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_hotelera";
    static String usuario = "root";
    static String password = "";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            System.out.println("error en le driver:" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("error al conectar:" + ex.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("error al cerrar:" + ex.getMessage());
        }
    }
}
