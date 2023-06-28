
package com.emergentes.dao;

import com.emergentes.modelo.Habitacion;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HabitacionDAOimpl extends ConexionDB implements HabitacionDAO{

    @Override
    public void insert(Habitacion habitacion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO habitacion (numero_habitacion,descripcion,max_ocupantes,precio) values (?,?,?,?)");
            ps.setInt(1, habitacion.getNumero_habitacion());
            ps.setString(2, habitacion.getDescripcion());
            ps.setInt(3, habitacion.getMax_ocupantes());
            ps.setFloat(4, habitacion.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Habitacion habitacion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE habitacion SET numero_habitacion = ?, descripcion =?,  max_ocupantes =?, precio =?  WHERE id_habitacion = ? ");
            ps.setInt(1, habitacion.getNumero_habitacion());
            ps.setString(2, habitacion.getDescripcion());
            ps.setInt(3, habitacion.getMax_ocupantes());
            ps.setFloat(4, habitacion.getPrecio());
            ps.setInt(5, habitacion.getId_habitacion());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_habitacion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM habitacion WHERE id_habitacion = ?");
            ps.setInt(1, id_habitacion);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Habitacion getById(int id_habitacion) throws Exception {
        Habitacion hab = new Habitacion();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM habitacion WHERE id_habitacion = ?");
            ps.setInt(1, id_habitacion);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hab.setId_habitacion(rs.getInt("id_habitacion"));
                hab.setNumero_habitacion(rs.getInt("numero_habitacion"));
                hab.setDescripcion(rs.getString("descripcion"));
                hab.setMax_ocupantes(rs.getInt("max_ocupantes"));
                hab.setPrecio(rs.getFloat("precio"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return hab;
    }

    @Override
    public List<Habitacion> getAll() throws Exception {
        List<Habitacion> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM habitacion");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Habitacion>();
            
            while (rs.next()) {
                Habitacion hab = new Habitacion();
                hab.setId_habitacion(rs.getInt("id_habitacion"));
                hab.setNumero_habitacion(rs.getInt("numero_habitacion"));
                hab.setDescripcion(rs.getString("descripcion"));
                hab.setMax_ocupantes(rs.getInt("max_ocupantes"));
                hab.setPrecio(rs.getFloat("precio"));

                lista.add(hab);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;

    }
    
}
