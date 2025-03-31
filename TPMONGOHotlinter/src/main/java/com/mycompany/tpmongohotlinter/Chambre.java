package com.mycompany.tpmongohotlinter;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Chambre {
    private int idChambre;
    
    private ObjectId id;
    
    private int numero;
    private int superficie; 
    private String description;
    private int tarif;
    
    private List<Reservataire>listReservataire = new ArrayList<>(); 
  

    public Chambre(int numero, int superficie, String description, int tarif) {
        this.numero = numero;
        this.superficie = superficie;
        this.description = description;
        this.tarif = tarif;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }
   
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public List<Reservataire> getListReservataire() {
        return listReservataire;
    }

    public void setListReservataire(List<Reservataire> listReservataire) {
        this.listReservataire = listReservataire;
    }
    
    //oobectID
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
  
}
