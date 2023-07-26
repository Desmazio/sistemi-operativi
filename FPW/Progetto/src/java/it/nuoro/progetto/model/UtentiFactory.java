/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.nuoro.progetto.model;

import it.nuoro.progetto.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtentiFactory {

    private static UtentiFactory instance;

    private UtentiFactory() {
    }

    public static UtentiFactory getInstance() {
        if (instance == null) {
            instance = new UtentiFactory();
        }
        return instance;
    }

    public Utenti getUtentebyUsernamePassword(String username, String password) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        Utenti utente = new Utenti();
        
        try {
        
            conn = DatabaseManager.getInstance().getDbConnection();
            
            String query = "SELECT * FROM utenti WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            set = stmt.executeQuery();

            if (set.next()) {
            
                utente.setEmail(set.getString("email"));
                utente.setPassword(set.getString("password"));
                utente.setUsername(set.getString("username"));
                utente.setTelefono(set.getString("telefono"));      
                return utente;
            } else {               
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {set.close(); } catch (Exception e) {}
            try {stmt.close(); } catch (Exception e) {}   
            try {conn.close(); } catch (Exception e) {}
            
            return utente;
               
        }
    }
}