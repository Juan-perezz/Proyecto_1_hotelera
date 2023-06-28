/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.modelo.Cliente;
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
@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

            int id;
            Cliente cli = new Cliente();
            ClienteDAO dao = new ClienteDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;

                case "edit":
                    id = Integer.parseInt(request.getParameter("id_cliente"));
                    cli = dao.getById(id);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_cliente"));
                    dao.delete(id);
                    response.sendRedirect("ClienteControlador");

                    break;
                case "view":
                    List<Cliente> lista = dao.getAll();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
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
        
         ClienteDAO dao = new ClienteDAOimpl();

        int id = Integer.parseInt(request.getParameter("id_cliente"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int ci = Integer.parseInt(request.getParameter("ci"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        String direccion = request.getParameter("direccion");

        Cliente cli = new Cliente();

        cli.setId_cliente(id);
        cli.setNombres(nombres);
        cli.setApellidos(apellidos);
        cli.setCi(ci);
        cli.setCelular(celular);
        cli.setDireccion(direccion);
        
        
        if(id==0){
            try {
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Erro al insertar"+ex.getMessage());
            }
        }else{
            try {
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Erro al editar"+ex.getMessage());
            }
        }
        
        response.sendRedirect("ClienteControlador");
    }

  
}
