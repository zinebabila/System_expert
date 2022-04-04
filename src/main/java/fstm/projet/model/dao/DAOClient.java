package fstm.projet.model.dao;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Compte;
import fstm.projet.model.bo.Diagnostic;
import fstm.projet.model.bo.Maladie_chronique;
import fstm.projet.model.bo.Region;
import fstm.projet.model.bo.Symptoms;

public class DAOClient implements IDAOClient {

    @Override
    public void insert(Client client) {
        DB baseDb = Connexion.getConnex();
        DBCollection collection = baseDb.getCollection("Client");

        ArrayList<DBObject> diagnostiques = new ArrayList<DBObject>();


        DBObject doc = new BasicDBObject("Nom", client.getNom())
                .append("prenom", client.getPrenom())
                .append("Sexe", client.getSexe())
                .append("Age", client.getage())
                .append("Email", client.getCmptCompte().getEmail())
                .append("Password", client.getCmptCompte().getPassword())
                .append("Diagnostiques", diagnostiques);


        collection.insert(doc);


    }

    @Override
    public void updateMaladie(Vector<Maladie_chronique> mal, String email) {
        /*DB baseDb = Connexion.getConnex();
        DBCollection collection = baseDb.getCollection("Client");
        ArrayList<DBObject> maladiesArrayList = new ArrayList<DBObject>();
        for (Maladie_chronique s : mal) {
            DBObject sYSDbObject = new BasicDBObject("Nom_maladie", s.getNom());
            maladiesArrayList.add(sYSDbObject);
        }
        BasicDBObject newDoc = new BasicDBObject();
        newDoc.append("$set", new BasicDBObject().append("Maladie_chronique", maladiesArrayList));
        BasicDBObject seaBasicDBObject = new BasicDBObject().append("Email", email);
        collection.update(seaBasicDBObject, newDoc);*/
    }

    @Override
    public void updateClient(Client c, double temp, Region reg) {
        /*DB baseDb = Connexion.getConnex();
        DBCollection collection = baseDb.getCollection("Client");
        System.out.println(c.getCmptCompte().getEmail());
        DBObject sYSDbObject = new BasicDBObject("Temperature", temp).append("Region", reg.getId_RE());
        BasicDBObject newDoc = new BasicDBObject();
        newDoc.append("$set", sYSDbObject);
        BasicDBObject seaBasicDBObject = new BasicDBObject().append("Email", c.getCmptCompte().getEmail());
        collection.update(seaBasicDBObject, newDoc);*/
       /* c.setTempareture(temp);
        c.setRegion(reg);*/

    }

    @Override
    public Boolean finfbyemail(String email) {
        Client client;
        DB baseDb = Connexion.getConnex();
        DBCollection collection = baseDb.getCollection("Client");

        DBObject object = new BasicDBObject("Email", email);


        DBCursor cursor = collection.find(object);
        return cursor != null;

    }

    @Override
    public Client Authentification(String email, String password) {
        Client client;
        DB baseDb = Connexion.getConnex();
        DBCollection collection = baseDb.getCollection("Client");

        DBObject object = new BasicDBObject("Email", email).append("Password", password);


        DBCursor cursor = collection.find(object);
        if (!cursor.hasNext()) {
            return null;
        } else {
            Client cli = null;
            Compte cmpCompte = null;
            ArrayList<Diagnostic> diagnostics = new ArrayList<>();

            DBObject object2 = cursor.next();
            try {
                JSONObject jsonObject = new JSONObject(JSON.serialize(object2));
                cli = new Client();
                cmpCompte = new Compte();

                int id;
                // cli.setId_Client(jsonObject.getInt("_id"));
                cli.setAge(jsonObject.getInt("Age"));
                cli.setNom(jsonObject.getString("Nom"));
                cli.setPrenom(jsonObject.getString("prenom"));
                /*cli.setTempareture(jsonObject.getInt("Temperature"));*/
                cli.setSexe(jsonObject.getBoolean("Sexe"));
                // id = jsonObject.getInt("Region");
               /* Region region = new DAORegion().findbyidRegion(id);
                cli.setRegion(region);*/
                cmpCompte.setEmail(jsonObject.getString("Email"));
                cmpCompte.setPassword(jsonObject.getString("Password"));
                cli.setCmptCompte(cmpCompte);
                

                // System.out.println(chroniques.get(0));

                //cli.setMaladies(chroniques);
                JSONArray json = jsonObject.getJSONArray("Diagnostiques");
                System.out.println(json);

                for (int i = 0; i < json.length(); i++) {

                    ///////////// Maladies
                    JSONArray json3 = json.getJSONObject(i).getJSONArray("Maladies_Chronique");
                    Vector<Maladie_chronique> chroniques = new Vector<>();
                    for (int j = 0; j < json3.length(); j++) {
                    	 System.out.println(json3.getJSONObject(j).getString("Nom_maladie"));
                        chroniques.add(new Maladie_chronique(json3.getJSONObject(j).getString("Nom_maladie")));
                    }

                    //////////// Symptoms
                    JSONArray json2 = json.getJSONObject(i).getJSONArray("Mysymtoms");
                    Vector<Symptoms> symptoms = new Vector<>();
                    for (int j = 0; j < json2.length(); j++) {
                        System.out.println(json2.getJSONObject(j).getInt("_idSy"));
                        symptoms.add(new Symptoms(json2.getJSONObject(j).getString("designation"), json2.getJSONObject(j).getInt("_idSy")));
                    }

                    diagnostics.add(new Diagnostic(symptoms,
                            json.getJSONObject(i).getDouble("resultat"),
                            cli,
                            LocalDate.parse(json.getJSONObject(i).getString("date")),
                            json.getJSONObject(i).getDouble("Temperature"),
                            new DAORegion().findbyidRegion(json.getJSONObject(i).getInt("Region")),
                            chroniques));
                }
                cli.setDiagnostics(diagnostics);


            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return cli;
        }
    }

    public void updateDiagnostique(Diagnostic diag, String email) {
        System.out.println(email);
        DB baseDb = Connexion.getConnex();
        DBCollection collection = baseDb.getCollection("Client");

        ArrayList<DBObject> symptomsArrayList = new ArrayList<DBObject>();
        for (Symptoms s : diag.Mysymtoms) {
            DBObject sYSDbObject = new BasicDBObject("designation", s.designation).append("_idSy", s.id_Sym);
            symptomsArrayList.add(sYSDbObject);
        }
        ArrayList<DBObject> maladies = new ArrayList<DBObject>();
        for (Maladie_chronique s : diag.getMaladies()) {
            DBObject sYSDbObject = new BasicDBObject("Nom_maladie", s.getNom());
            maladies.add(sYSDbObject);
        }
        DBObject doc = new BasicDBObject("Mysymtoms", symptomsArrayList)
                .append("Maladies_Chronique", maladies)
                .append("resultat", diag.get_possi_presence())
                .append("Temperature", diag.getTemperature())
                .append("Region", diag.getRegion().getId_RE())
                .append("date", diag.getDate().toString());


        BasicDBObject newDoc = new BasicDBObject();

        newDoc.append("$push", new BasicDBObject().append("Diagnostiques", doc));
        BasicDBObject seaBasicDBObject = new BasicDBObject().append("Email", email);
        collection.update(seaBasicDBObject, newDoc);
    }


}