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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdottiFactory {
    
    private static ProdottiFactory instance;

    private ProdottiFactory() {
    }

    public static ProdottiFactory getInstance() {
        if (instance == null) {
            instance = new ProdottiFactory();
        }
        return instance;
    }
    
    public Prodotti getProdotto(String offset){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        Prodotti prodotto = new Prodotti();
        
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            
            String query = "SELECT * FROM prodotti LIMIT 1 OFFSET ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(offset));
            
            set = stmt.executeQuery();
            while(set.next()){
                prodotto.setTitolo(set.getString("titolo"));
                prodotto.setTipologia(set.getString("tipologia"));
                prodotto.setDescrizione(set.getString("descrizione"));
                prodotto.setPrezzo(set.getString("prezzo"));
                prodotto.setTelefono(set.getString("utenti_tel"));
                prodotto.setPathFoto(set.getString("foto_path"));
            }
            
            return prodotto;
        } catch(SQLException e){
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {set.close(); } catch (Exception e) {}
            try {stmt.close(); } catch (Exception e) {}   
            try {conn.close(); } catch (Exception e) {}
            
            return prodotto;
               
        }
        
        
    }
    
    public List<Prodotti> getAllProdotti() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<Prodotti> prodotti = new ArrayList<>();
        
        try {
            conn = DatabaseManager.getInstance().getDbConnection();

            String query = "SELECT * FROM prodotti";
            stmt = conn.prepareStatement(query);

            set = stmt.executeQuery();

            while (set.next()) {
                Prodotti prodotto = new Prodotti();
                prodotto.setTitolo(set.getString("titolo"));
                prodotto.setTipologia(set.getString("tipologia"));
                prodotto.setDescrizione(set.getString("descrizione"));
                prodotto.setPrezzo(set.getString("prezzo"));
                prodotto.setTelefono(set.getString("utenti_tel"));
                prodotto.setPathFoto(set.getString("foto_path"));
                
                prodotti.add(prodotto);
            }
            
            return prodotti;
            
        } catch (SQLException e) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {set.close(); } catch (Exception e) {}
            try {stmt.close(); } catch (Exception e) {}   
            try {conn.close(); } catch (Exception e) {}
            
            return prodotti;
               
        }
    }
    
}
