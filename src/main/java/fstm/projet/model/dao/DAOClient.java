package fstm.projet.model.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

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
				 .append("Region", client.getRegion().getId_RE())
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
	@Override
	public void updateClient(String email,double temp,Region reg) {
		DB baseDb=Connexion.getConnex();
		DBCollection collection=baseDb.getCollection("Client");
		
		
		
	DBObject sYSDbObject=new BasicDBObject("Temperature",temp).append("Region",reg.getId_RE());
				
		
		BasicDBObject newDoc=new BasicDBObject();
		newDoc.append("$set",sYSDbObject );
		BasicDBObject seaBasicDBObject=new BasicDBObject().append("Email", email);
		collection.update(seaBasicDBObject, newDoc);
		
	}
	@Override
	public Boolean finfbyemail(String email) {
		Client client;
		DB baseDb=Connexion.getConnex();
		DBCollection collection=baseDb.getCollection("Client");
		
		DBObject object=new BasicDBObject("Email",email);
		
		
		DBCursor cursor=collection.find(object);
		if(cursor!=null) return true;
		return false;
		
	}
	@Override
	public Client Authentification(String email, String password) {
		Client client;
		DB baseDb=Connexion.getConnex();
		DBCollection collection=baseDb.getCollection("Client");
		
		DBObject object=new BasicDBObject("Email",email).append("Password",password );
		
		
		DBCursor cursor=collection.find(object);
		if(cursor.hasNext() == false) {
			return null;
		}
		else {
			Client cli=null;
			
				DBObject object2=cursor.next();
				try {
					JSONObject jsonObject=new JSONObject(JSON.serialize(object2));
					 cli=new Client();
					cli.setAge(jsonObject.getInt("Age"));
					cli.setNom(jsonObject.getString("Nom"));
					cli.setPrenom(jsonObject.getString("prenom"));
					cli.setSexe(jsonObject.getBoolean("Sexe"));
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			
				return cli;	
		}
	}

}
