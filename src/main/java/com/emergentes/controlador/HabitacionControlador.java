/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.HabitacionDAO;
import com.emergentes.dao.HabitacionDAOimpl;
import com.emergentes.modelo.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "HabitacionControlador", urlPatterns = {"/HabitacionControlador"})
public class HabitacionControlador extends HttpServlet {

  
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {

            int id;
            Habitacion hab = new Habitacion();
            HabitacionDAO dao = new HabitacionDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("habitacion", hab);
                    request.getRequestDispatcher("frmhabitacion.jsp").forward(request, response);
                    break;

                case "edit":
                    id = Integer.parseInt(request.getParameter("id_habitacion"));
                    hab = dao.getById(id);
                    request.setAttribute("habitacion", hab);
                    request.getRequestDispatcher("frmhabitacion.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_habitacion"));
                    dao.delete(id);
                    response.sendRedirect("HabitacionControlador");

                    break;
                case "view":
                    List<Habitacion> lista = dao.getAll();
                    request.setAttribute("habitaciones", lista);
                    request.getRequestDispatcher("habitaciones.jsp").forward(request, response);
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
        
         HabitacionDAO dao = new HabitacionDAOimpl();

        int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
        int numero_habitacion = Integer.parseInt(request.getParameter("numero_habitacion"));
        String descripcion = request.getParameter("descripcion");
        int max_ocupantes = Integer.parseInt(request.getParameter("max_ocupantes"));
        Float precio = Float.parseFloat(request.getParameter("precio"));

        Habitacion hab = new Habitacion();

        hab.setId_habitacion(id_habitacion);
        hab.setNumero_habitacion(numero_habitacion);
        hab.setDescripcion(descripcion);
        hab.setMax_ocupantes(max_ocupantes);
        hab.setPrecio(precio);
        
        
        if(id_habitacion==0){
            try {
                dao.insert(hab);
            } catch (Exception ex) {
                System.out.println("Erro al insertar"+ex.getMessage());
            }
        }else{
            try {
                dao.update(hab);
            } catch (Exception ex) {
                System.out.println("Erro al editar"+ex.getMessage());
            }
        }
        
        response.sendRedirect("HabitacionControlador");
    }

}
