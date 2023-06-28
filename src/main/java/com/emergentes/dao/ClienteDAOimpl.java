package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends ConexionDB implements ClienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO cliente (nombres,apellidos,ci,celular,direccion) values (?,?,?,?,?)");
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setInt(3, cliente.getCi());
            ps.setInt(4, cliente.getCelular());
            ps.setString(5, cliente.getDireccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE cliente SET nombres = ?, apellidos =?, ci = ?, celular =?,direccion = ?  WHERE id_cliente = ? ");
            
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setInt(3, cliente.getCi());
            ps.setInt(4, cliente.getCelular());
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getId_cliente());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
            ps.setInt(1, id_cliente);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cliente getById(int id_cliente) throws Exception {
        Cliente cli = new Cliente();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ?");
            ps.setInt(1, id_cliente);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCi(rs.getInt("ci"));
                cli.setCelular(rs.getInt("celular"));
                cli.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Cliente>();
            
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCi(rs.getInt("ci"));
                cli.setCelular(rs.getInt("celular"));
                cli.setDireccion(rs.getString("direccion"));

                lista.add(cli);
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
