/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.nuoro.progetto.servlet;

import it.nuoro.progetto.db.DatabaseManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

import it.nuoro.progetto.exceptions.*;
import it.nuoro.progetto.model.Prodotti;
import it.nuoro.progetto.model.Utenti;
import it.nuoro.progetto.utils.*;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author paual */
@MultipartConfig()
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String username = session.getAttribute("username").toString();
            
            String titolo = request.getParameter("titolo");
            String prezzo = request.getParameter("prezzo");
            String descrizione = request.getParameter("descrizione");
            String tipologia = request.getParameter("tipologia");
            Part imgPart = request.getPart("immagine");
            
            try{
                Utils.checkString(titolo, 5, 30);
                Utils.checkInteger(prezzo, 0, 999999999);
                Utils.checkString(descrizione, 20, 500);
                Utils.checkRadio(tipologia);
                
                Prodotti prodotto = new Prodotti();
                prodotto.setTitolo(titolo);
                prodotto.setTipologia(tipologia);
                prodotto.setDescrizione(descrizione);
                prodotto.setPrezzo(prezzo);
                
                //Upload immagine
                try(InputStream contenutoFile = imgPart.getInputStream()){
                    File fileDaSalvare = new File("C:\\Users\\paual\\Desktop\\Uni\\Sistemi Operativi\\Shared\\sistemi-operativi\\FPW\\Progetto\\web\\img\\annunci\\" + imgPart.getSubmittedFileName());
                    Files.copy(contenutoFile, fileDaSalvare.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch(IOException e){
                    throw new InvalidParamException("Errore nel caricamento dell'immagine");
                }
                
                String imgPath = "img/annunci/" + imgPart.getSubmittedFileName();
                prodotto.setPathFoto(imgPath);

                DatabaseManager dbManager = DatabaseManager.getInstance();
                Connection conn = dbManager.getDbConnection();

                if(insertProdotto(conn, prodotto, username)){
                    response.sendRedirect(request.getContextPath() + "/annuncio_creato.jsp");
                }
                    
                else
                    throw new InvalidParamException("Errore nella creazione dell'annuncio");
            
            }catch(InvalidParamException e){
                request.setAttribute("errorType", "annuncio");
                request.setAttribute("errorMessage", e.getMessage());
                request.setAttribute("link", "crea_annuncio.jsp");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }            
        }
    }
    
    private boolean insertProdotto(Connection conn, Prodotti prodotto, String username) throws SQLException {
        String query = "INSERT INTO prodotti (titolo, tipologia, prezzo, descrizione, utenti_id, utenti_tel, foto_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, prodotto.getTitolo());
            statement.setString(2, prodotto.getTipologia());
            statement.setString(3, prodotto.getPrezzo());
            statement.setString(4, prodotto.getDescrizione());
            statement.setString(7, prodotto.getPathFoto());
            
            // Questa sezione procede a prelevare dal database e a settare nel Prepared Statement principale l'id utente e il telefono
            String queryInfo = "SELECT * FROM utenti WHERE username = ?";
            PreparedStatement infoStmt = conn.prepareStatement(queryInfo);
            infoStmt.setString(1, username);
            
            ResultSet set = infoStmt.executeQuery();
            if(set.next()){
                statement.setInt(5, set.getInt("id"));
                statement.setString(6, set.getString("telefono"));
            }
            else
                throw new SQLException();
            
            statement.executeUpdate();
            
            return true;
        }catch(SQLException e){
             System.out.println("Errore di database: " + e);
             return false;
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AnnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AnnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
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