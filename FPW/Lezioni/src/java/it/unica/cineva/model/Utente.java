/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unica.cineva.model;

import java.util.Objects;

/**
 *
 * @author mrobb
 */
public class Utente {
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String email;
    private String foto;
    
    public Utente(){}
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(this == null)
            return false;
        
        if(getClass() != obj.getClass())
            return false;
        final Utente other = (Utente)obj;
        if(!Objects.equals(this.username, other.username))
            return false;
        return true;
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash =  79 * hash + Objects.hashCode(this.username);
        return hash;
    }
    
}
