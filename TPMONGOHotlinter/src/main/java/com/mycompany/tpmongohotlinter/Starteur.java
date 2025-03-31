/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tpmongohotlinter;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author thibault
 */
public class Starteur {

    public static void main(String[] args) {

        Client c1 = new Client("Bailly", "thibault", 06401211, "tb@gmail.com", 39130, "rue du lila", "bonlieu", "21/01/2024");
        Client c2 = new Client("MICHALET", "Noah", 06201020, "noah@gmail.com", 39130, "rue du tablier", "Lons", "23/01/2024");
        Chambre ch1 = new Chambre(221, 20, "T2", 220);
        Chambre ch2 = new Chambre(210, 50, "T3", 400);
        Reservataire r1 = new Reservataire(21012024, 30012024, "CB");
        Reservataire r2 = new Reservataire(01022024, 10022024, "Cheque");

        //List
        List<Chambre> listChambre = new ArrayList<>();
        listChambre.add(ch1);
        listChambre.add(ch2);

        List<Client> listClient = new ArrayList<>();
        listClient.add(c1);
        listClient.add(c2);

        List<Reservataire> listReservataire = new ArrayList<>();
        listReservataire.add(r1);
        listReservataire.add(r2);

        c1.getListReservataire().add(r1);
        c2.getListReservataire().add(r2);
        ch1.getListReservataire().add(r1);
        ch2.getListReservataire().add(r2);
        r1.Addchambre(ch1);
        r2.Addchambre(ch2);

        r1.setClient(c1);
        r2.setClient(c2);

        //connecter
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        //connexion à la base de données
        MongoDatabase database = mongoClient.getDatabase("Hotelinter");

        MongoCollection<Document> collectionClient = database.getCollection("Client");
        MongoCollection<Document> collectionChambre = database.getCollection("Chambre");
        MongoCollection<Document> collectionReservataire = database.getCollection("Reservataire");

        //supprimer
        database.getCollection("Client").deleteMany(new Document());
        database.getCollection("Chambre").deleteMany(new Document());
        database.getCollection("Reservataire").deleteMany(new Document());

        //client1
        Document documentClient1 = new Document();
        documentClient1.append("nom", c1.getNom());
        documentClient1.append("Prenom", c1.getPrenom());
        documentClient1.append("tel", c1.getTel());
        documentClient1.append("mail", c1.getMail());
        documentClient1.append("Date", c1.getDate());
        documentClient1.append("Reservation", "");
        collectionClient.insertOne(documentClient1);
        //client2
        Document documentClient2 = new Document();
        documentClient2.append("nom", c2.getNom());
        documentClient2.append("Prenom", c2.getPrenom());
        documentClient2.append("tel", c2.getTel());
        documentClient2.append("mail", c2.getMail());
        documentClient2.append("Date", c2.getDate());
        documentClient2.append("Reservation", "");
        collectionClient.insertOne(documentClient2);
        //chambre1
        Document documentChambre1 = new Document();
        documentChambre1.append("Chambre", ch1.getNumero());
        documentChambre1.append("M²", ch1.getSuperficie());
        documentChambre1.append("Description", ch1.getDescription());
        documentChambre1.append("Prix", ch1.getTarif());
        documentChambre1.append("Reservation", new ArrayList<>());
        collectionChambre.insertOne(documentChambre1);
        //chambre2
        Document documentChambre2 = new Document();
        documentChambre2.append("Chambre", ch2.getNumero());
        documentChambre2.append("M²", ch2.getSuperficie());
        documentChambre2.append("Description", ch2.getDescription());
        documentChambre2.append("Prix", ch2.getTarif());
        documentChambre2.append("Reservation", new ArrayList<>());
        collectionChambre.insertOne(documentChambre2);
        //Reservataire1
        Document documentReservataire1 = new Document();
        documentReservataire1.append("Debut", r1.getDebutSejour());
        documentReservataire1.append("Fin", r1.getFinSejour());
        documentReservataire1.append("Paiement", r1.getPaiement());
        documentReservataire1.append("Client", "");
        documentReservataire1.append("Chambre", new ArrayList<>());
        collectionReservataire.insertOne(documentReservataire1);
        //Reservataire2
        Document documentReservataire2 = new Document();
        documentReservataire2.append("Debut", r2.getDebutSejour());
        documentReservataire2.append("Fin", r2.getFinSejour());
        documentReservataire2.append("Paiement", r2.getPaiement());
        documentReservataire2.append("Client", "");
        documentReservataire2.append("Chambre", new ArrayList<>());
        collectionReservataire.insertOne(documentReservataire2);

        //Association
        c1.setId((ObjectId) documentClient1.get("_id"));
        c2.setId((ObjectId) documentClient2.get("_id"));
        r1.setObj((ObjectId) documentReservataire1.get("_id"));
        r2.setObj((ObjectId) documentReservataire2.get("_id"));

        ch1.setId((ObjectId) documentChambre1.get("_id"));
        ch2.setId((ObjectId) documentChambre2.get("_id"));
        r1.setObj((ObjectId) documentReservataire1.get("_id"));
        r2.setObj((ObjectId) documentReservataire2.get("_id"));

        // private List<Reservataire>listReservataire = new ArrayList<>(); 
        for (Client c : listClient) {

            List<ObjectId> obj = new ArrayList<>();

            for (Reservataire r : listReservataire) {

                if (c.getListReservataire().contains(r)) {
                    obj.add(r.getObj());
                }
                Document avant = new Document("_id", c.getId());
                Document apres = new Document("$set", new Document("Reservation", obj));
                collectionClient.updateOne(avant, apres);
            }
        }
        // private List<Reservataire>listReservataire = new ArrayList<>(); 
        for (Chambre c : listChambre) {
            List<ObjectId> obj = new ArrayList<>();
            for (Reservataire r : c.getListReservataire()) {
                obj.add(r.getObj());
            }
            Document avant = new Document("_id", c.getId());
            Document apres = new Document("$set", new Document("Reservation", obj));
            collectionChambre.updateOne(avant, apres);
        }
        //private Client client;
        for (Reservataire r : listReservataire) {
            ObjectId clientId = r.getClient().getId();
            Document avant = new Document("_id", r.getObj());
            Document apres = new Document("$set", new Document("Client", clientId));
            collectionReservataire.updateOne(avant, apres);
        }
        //private List<Chambre>listChambre= new ArrayList<>(); 
        for (Reservataire r : listReservataire) {
            List<ObjectId> obj = new ArrayList<>();
            for (Chambre c : r.getListChambre()) {
                obj.add(c.getId());
            }
            Document avant = new Document("_id", r.getObj());
            Document apres = new Document("$set", new Document("Chambre", obj));
            collectionReservataire.updateOne(avant, apres);
        }
        //Afficher les collections
        for (String name : database.listCollectionNames()) {
            System.out.println("Collection trouvé : " + name);
        }
    }
}
