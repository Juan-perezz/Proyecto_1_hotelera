/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.dao.HabitacionDAO;
import com.emergentes.dao.HabitacionDAOimpl;
import com.emergentes.dao.ReservaDAO;
import com.emergentes.dao.ReservaDAOimpl;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Habitacion;
import com.emergentes.modelo.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ReservaControlador", urlPatterns = {"/ReservaControlador"})
public class ReservaControlador extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            ReservaDAO dao = new ReservaDAOimpl();
            HabitacionDAO daoHabitacion = new HabitacionDAOimpl();
            ClienteDAO daoCliente = new ClienteDAOimpl();
            int id;
            List<Habitacion> lista_habitacion = null;
            List<Cliente> lista_clientes = null;
            Reserva reserva = new Reserva();
              
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_habitacion = daoHabitacion.getAll();
                    lista_clientes = daoCliente.getAll();
                    request.setAttribute("lista_habitacion",lista_habitacion );
                    request.setAttribute("lista_clientes",lista_clientes );
                    
                    request.setAttribute("reserva", reserva);
                    request.getRequestDispatcher("frmreserva.jsp").forward(request, response);
                    break;

                case "edit":
                    id = Integer.parseInt(request.getParameter("id_reserva"));
                    reserva = dao.getById(id);
                    lista_habitacion = daoHabitacion.getAll();
                    lista_clientes = daoCliente.getAll();
                    request.setAttribute("lista_habitacion",lista_habitacion );
                    request.setAttribute("lista_clientes",lista_clientes );
                    request.setAttribute("reserva", reserva);
                    request.getRequestDispatcher("frmreserva.jsp").forward(request, response);
                    
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_reserva"));
                    dao.delete(id);
                    response.sendRedirect("ReservaControlador");

                    break;
                case "view":
                    List<Reserva> lista = dao.getAll();
                    request.setAttribute("reservas", lista);
                    request.getRequestDispatcher("reservas.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ReservaDAO dao = new ReservaDAOimpl();

        int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fecha_entrada = request.getParameter("fecha_entrada");
        String fecha_salida = request.getParameter("fecha_salida");

        Reserva reserva = new Reserva();

        reserva.setId_reserva(id_reserva);
        reserva.setId_cliente(id_cliente);
        reserva.setId_habitacion(id_habitacion);
        reserva.setCantidad(cantidad);
        reserva.setFecha_entrada(convierteFecha(fecha_entrada));
        reserva.setFecha_salida(convierteFecha(fecha_salida));
        
        
        if(id_reserva==0){
            try {
                dao.insert(reserva);
            } catch (Exception ex) {
                Logger.getLogger(ReservaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            try {
                dao.update(reserva);
            } catch (Exception ex) {
                Logger.getLogger(ReservaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
        response.sendRedirect("ReservaControlador");
        
    }
    
    public Date convierteFecha (String fecha){
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(ReservaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fechaBD;
    }

}
