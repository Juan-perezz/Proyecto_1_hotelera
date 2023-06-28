/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.utiles.Valedate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        System.out.println("Datos" + correo + " " + password);
        // verificar lo datos
        Valedate v = new Valedate();
        if(v.checkUser(correo, password)){
           // System.out.println("todo ok");
           HttpSession ses = request.getSession();
           ses.setAttribute("login", "ok");
           response.sendRedirect("ClienteControlador");
           
        }else{
            //System.out.println("incorrecto");
            response.sendRedirect("login.jsp");
            
        }
    }

}
