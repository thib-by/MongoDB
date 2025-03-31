package com.mycompany.tpmongohotlinter;



import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author thibault
 */
public class Reservataire {
    private int idReservataire;
    private ObjectId obj;
    
    private int debutSejour;
    private int finSejour;
    private String Paiement;

    private Client client;
    private List<Chambre>listChambre= new ArrayList<>(); 
    
    public Reservataire(int debutSejour, int finSejour, String Paiement) {
        this.debutSejour = debutSejour;
        this.finSejour = finSejour;
        this.Paiement = Paiement;
    }
    
    public void Addchambre(Chambre ch1)
    {
        this.listChambre.add(ch1);
    } 

    public int getIdReservataire() {
        return idReservataire;
    }

    public void setIdReservataire(int idReservataire) {
        this.idReservataire = idReservataire;
    }

    public int getDebutSejour() {
        return debutSejour;
    }

    public void setDebutSejour(int debutSejour) {
        this.debutSejour = debutSejour;
    }

    public int getFinSejour() {
        return finSejour;
    }

    public void setFinSejour(int finSejour) {
        this.finSejour = finSejour;
    }

    public String getPaiement() {
        return Paiement;
    }

    public void setPaiement(String Paiement) {
        this.Paiement = Paiement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Chambre> getListChambre() {
        return listChambre;
    }

    public void setListChambre(List<Chambre> listChambre) {
        this.listChambre = listChambre;
    }

    public ObjectId getObj() {
        return obj;
    }

    public void setObj(ObjectId obj) {
        this.obj = obj;
    }

    void setChambre(Chambre ch1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getChambre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
}
