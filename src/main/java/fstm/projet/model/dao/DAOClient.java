package fstm.projet.model.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Compte;
import fstm.projet.model.bo.Diagnostic;
import fstm.projet.model.bo.Maladie_chronique;
import fstm.projet.model.bo.Symptoms;

public class DAOClient implements IDAOClient {

	@Override
	public void insert(Client client) {
		DB baseDb=Connexion.getConnex();
DBCollection collection=baseDb.getCollection("Client");


ArrayList< DBObject> maladiesArrayList=new ArrayList<DBObject>();
for(Maladie_chronique s:client.getMaladies()) {
		DBObject sYSDbObject=new BasicDBObject("Nom_maladie",s.getNom());
		maladiesArrayList.add(sYSDbObject);
}
		DBObject doc = new BasicDBObject("Nom",client.getNom())
				 .append("prenom",client.getPrenom())
				 .append("Sexe",client.getSexe())
				 .append("Temperature", client.getTempareture())
				 .append("Age", client.getage())
				 .append("Email", client.getCmptCompte().getEmail())
				 .append("Password", client.getCmptCompte().getPassword())
				 .append("Maladie_chronique", maladiesArrayList);
				
				 collection.insert(doc);
	
	
	}
	public void updateMaladie(Vector<Maladie_chronique>mal,String email) {
		DB baseDb=Connexion.getConnex();
		DBCollection collection=baseDb.getCollection("Client");
		
		ArrayList< DBObject> maladiesArrayList=new ArrayList<DBObject>();
		for(Maladie_chronique s:mal) {
				DBObject sYSDbObject=new BasicDBObject("Nom_maladie",s.getNom());
				maladiesArrayList.add(sYSDbObject);
		}
		
		BasicDBObject newDoc=new BasicDBObject();
		newDoc.append("$set",new BasicDBObject().append("Maladie_chronique", maladiesArrayList) );
		BasicDBObject seaBasicDBObject=new BasicDBObject().append("Email", email);
		collection.update(seaBasicDBObject, newDoc);
	}

}
