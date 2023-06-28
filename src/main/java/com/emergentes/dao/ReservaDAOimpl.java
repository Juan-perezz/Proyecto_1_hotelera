
package com.emergentes.dao;

import com.emergentes.modelo.Reserva;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAOimpl extends ConexionDB implements ReservaDAO{

    @Override
    public void insert(Reserva reserva) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO reserva (id_cliente,id_habitacion,cantidad,fecha_entrada,fecha_salida) values (?,?,?,?,?)");
            ps.setInt(1, reserva.getId_cliente());
            ps.setInt(2, reserva.getId_habitacion());
            ps.setInt(3, reserva.getCantidad());
            ps.setDate(4, reserva.getFecha_entrada());
            ps.setDate(5, reserva.getFecha_salida());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        
    }

    @Override
    public void update(Reserva reserva) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE reserva SET id_cliente = ?, id_habitacion =?,cantidad = ?, fecha_entrada =?,fecha_salida = ?  WHERE id_reserva = ? ");
            
            ps.setInt(1, reserva.getId_cliente());
            ps.setInt(2, reserva.getId_habitacion());
            ps.setInt(3, reserva.getCantidad());
            ps.setDate(4, reserva.getFecha_entrada());
            ps.setDate(5, reserva.getFecha_salida());
            ps.setInt(6, reserva.getId_reserva());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        
    }

    @Override
    public void delete(int id_reserva) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM reserva WHERE id_reserva = ?");
            ps.setInt(1, id_reserva);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Reserva getById(int id_reserva) throws Exception {
        Reserva res = new Reserva();
        
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM reserva WHERE id_reserva = ?");
            ps.setInt(1, id_reserva);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res.setId_reserva(rs.getInt("id_reserva"));
                res.setId_cliente(rs.getInt("id_cliente"));
                res.setId_habitacion(rs.getInt("id_habitacion"));
                res.setCantidad(rs.getInt("cantidad"));
                res.setFecha_entrada(rs.getDate("fecha_entrada"));
                res.setFecha_salida(rs.getDate("fecha_salida"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;
        
    }

    @Override
    public List<Reserva> getAll() throws Exception {
        List<Reserva> lista = null;
        try {
            this.conectar();
            String sql = "SELECT res.*,p.numero_habitacion as habitacion, c.nombres as cliente FROM reserva res ";
            sql += "LEFT JOIN habitacion p ON res.id_habitacion = p.id_habitacion ";
            sql += "LEFT JOIN cliente c ON res.id_cliente = c.id_cliente";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Reserva>();
            
            while (rs.next()) {
                Reserva res = new Reserva();
                res.setId_reserva(rs.getInt("id_reserva"));
                res.setId_habitacion(rs.getInt("id_habitacion"));
                res.setId_cliente(rs.getInt("id_cliente"));
                res.setCantidad(rs.getInt("cantidad"));
                res.setFecha_entrada(rs.getDate("fecha_entrada"));
                res.setFecha_salida(rs.getDate("fecha_salida"));
                res.setCliente(rs.getString("cliente"));
                res.setHabitacion(rs.getString("habitacion"));
                
                lista.add(res);
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
