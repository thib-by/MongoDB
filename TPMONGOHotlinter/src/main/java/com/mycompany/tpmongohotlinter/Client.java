package com.mycompany.tpmongohotlinter;



import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thibault
 */
public class Client {
    private int idClient;
    private ObjectId id;
    
    private String nom;
    private String prenom;
    private int tel ;
    private String mail;
    private int cp;
    private String rue;
    private String ville;
    private String Date ;
    

    private List<Reservataire>listReservataire = new ArrayList<>(); 
    
    public Client(String nom, String prenom, int tel, String mail, int cp, String rue, String ville, String Date) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.cp = cp;
        this.rue = rue;
        this.ville = ville;
        this.Date = Date;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public List<Reservataire> getListReservataire() {
        return listReservataire;
    }

    public void setListReservataire(List<Reservataire> listReservataire) {
        this.listReservataire = listReservataire;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    
    
    
    
    
}
