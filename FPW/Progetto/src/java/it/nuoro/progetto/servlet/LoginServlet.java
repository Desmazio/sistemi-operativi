/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.nuoro.progetto.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.nuoro.progetto.exceptions.*;
import it.nuoro.progetto.utils.*;

/**
 *
 * @author mrobb
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try{
            
            Utils.checkString(username, 3, 20);
            Utils.checkString(password, 5, 20);
            
            if(login(username, password)){
                session.setAttribute("username", username);
                session.setMaxInactiveInterval(30);
                response.sendRedirect("AreaPersonale"); 
            }
            else{
                throw new InvalidParamException("Username o password non validi!");
            }
        }catch(InvalidParamException e){
            session.invalidate();
            request.setAttribute("errorType", "login");
            request.setAttribute("errorMessage", e.getMessage());
            request.setAttribute("link", "login.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
             
    }

    private boolean login(String username, String password){
        return (username.equals("Pau") && password.equals("66103") ||
                username.equals("Todde") && password.equals("matricolaTodde") ||
                username.equals("Pisanu") && password.equals("matricolaPisanu") ||
                username.equals("Simbola") && password.equals("matricolaSimbola"));
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
