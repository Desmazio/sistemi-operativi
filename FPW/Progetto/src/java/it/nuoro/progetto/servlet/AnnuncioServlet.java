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
 * @author paual
 */
@WebServlet(name = "AnnuncioServlet", urlPatterns = {"/AnnuncioServlet"})
public class AnnuncioServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            String titolo = request.getParameter("titolo");
            String prezzo = request.getParameter("prezzo");
            String descrizione = request.getParameter("descrizione");
            String tipologia = request.getParameter("tipologia");
            
            try{
                Utils.checkString(titolo, 5, 20);
                Utils.checkInteger(prezzo, 0, 999999999);
                Utils.checkString(descrizione, 20, 1000);
                Utils.checkRadio(tipologia);
                
                if(creaAnnuncio()){
                    response.sendRedirect(request.getContextPath() + "/annuncio_creato.jsp"); 
                }
                else
                    throw new InvalidParamException("Errore nella creazione dell'annuncio");
            
            }catch(InvalidParamException e){
                request.setAttribute("errorType", "annuncio");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            
        }
    }
    
    private boolean creaAnnuncio(){
        // Possibilmente roba di server, serve comunque per il funzionamento della servlet
        return true;
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
