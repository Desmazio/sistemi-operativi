/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.unica.cineva.servlet;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unica.cineva.exceptions.*;
import it.unica.cineva.utils.*;

/**
 *
 * @author paual
 */
@WebServlet(name = "RecensioneServlet", urlPatterns = {"/review"})
public class RecensioneServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String name = request.getParameter("titolo");
        String descrizione = request.getParameter("descrizione");
        String tipologia = request.getParameter("tipologia");
        String voto = request.getParameter("voto");
        String message = "Recensione scritta correttamente!";
        int minString = 5, maxString = 50;
        
        try{
            Utils.checkString(name, minString, maxString);
            Utils.checkString(descrizione, minString, maxString);
            Utils.checkString(tipologia, 0, maxString);
            Utils.checkInteger(voto, 1, 5);
            
            List<String> listaFilm = new ArrayList<>();
            listaFilm.add("Shutter Island");
            listaFilm.add("Joker");
            listaFilm.add("Shrek");
            request.setAttribute("listaFilm", listaFilm);
            request.getRequestDispatcher("recensioneInserita.jsp").forward(request, response);
        }
        catch(InvalidParamException e){
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
