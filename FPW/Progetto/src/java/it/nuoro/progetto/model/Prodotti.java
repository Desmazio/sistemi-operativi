/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.nuoro.progetto.model;

import java.util.Objects;

public class Prodotti {

        private int Id;
        private String titolo;
        private String tipologia;
        private String descrizione;
        private String prezzo;
        private String telefono;
        private String pathFoto;
        
        public Prodotti() {}
    
    
        
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String nome) {
        this.titolo = nome;
    }
    
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setPathFoto(String path){
        this.pathFoto = path;
    }
    
    public String getPathFoto() {
        return pathFoto;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prodotti other = (Prodotti) obj;
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.titolo);
        return hash;
    }
}