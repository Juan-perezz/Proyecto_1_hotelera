
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Valedate extends ConexionDB {
    Connection con = this.conectar();
    PreparedStatement pr;
     
    public boolean checkUser(String correo,String password){
        
        boolean resultado = false;
        try {
            
            String sql = "select * from usuarios where correo=? and password = ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, correo);
            pr.setString(2, password);
            
            ResultSet rs = pr.executeQuery();
            resultado = rs.next();
            
            
        } catch (SQLException ex) {
             System.out.println("error");
        }
        return  resultado;
    }
    
    
}
