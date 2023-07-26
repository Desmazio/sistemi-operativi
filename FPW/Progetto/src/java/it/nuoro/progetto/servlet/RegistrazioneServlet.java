/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.nuoro.progetto.servlet;

import it.nuoro.progetto.db.DatabaseManager;
import it.nuoro.progetto.model.Utenti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.nuoro.progetto.exceptions.InvalidParamException;
import it.nuoro.progetto.utils.Utils;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author paual */
@WebServlet(name = "RegistrazioneServlet", urlPatterns = {"/RegistrazioneServlet"})
public class RegistrazioneServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        try{
            
            Utils.checkString(username, 3, 20);
            Utils.checkString(password, 5, 20);
            Utils.checkString(email, 3, 30);
            Utils.checkTelephoneNumber(telefono);
            
            Utenti utente = new Utenti();
            utente.setUsername(username);
            utente.setPassword(password);
            utente.setEmail(email);
            utente.setTelefono(telefono);
            
            DatabaseManager dbManager = DatabaseManager.getInstance();
            Connection conn = dbManager.getDbConnection();
            
            //Se i valori non sono già presenti nel database, carica i valori nel database
            if(!isUtenteRepeated(conn, utente))
                insertUtente(conn, utente);
            else
                throw new InvalidParamException("L'username e/o l'email sono già utilizzati.");
            
            session.setAttribute("username", username);
            session.setAttribute("email", email);
            session.setAttribute("telefono", telefono);
            session.setMaxInactiveInterval(30);
            response.sendRedirect("AreaPersonale");
            
        }catch(InvalidParamException e){
            session.invalidate();
            request.setAttribute("errorType", "login");
            request.setAttribute("errorMessage", e.getMessage());
            request.setAttribute("link", "registrati.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }        
    }
    
    private void insertUtente(Connection conn, Utenti utente) throws SQLException {
        String query = "INSERT INTO utenti (username, password, email, telefono) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, utente.getUsername());
            statement.setString(2, utente.getPassword());
            statement.setString(3, utente.getEmail());
            statement.setString(4, utente.getTelefono());
            statement.executeUpdate();
        }
    }

    private boolean isUtenteRepeated(Connection conn, Utenti utente) throws SQLException {
        String query;
        PreparedStatement stmt;
        ResultSet set;
        
        query = "SELECT FROM utenti WHERE username = ? OR email = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, utente.getUsername());
        stmt.setString(2, utente.getEmail());

        set = stmt.executeQuery();

        // set.next() vale true se i dati sono già presenti, altrimenti vale false
        return set.next();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrazioneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrazioneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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