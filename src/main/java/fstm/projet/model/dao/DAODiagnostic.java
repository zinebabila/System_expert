package fstm.projet.model.dao;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import fstm.projet.model.bo.Diagnostic;
import fstm.projet.model.bo.Symptoms;

public class DAODiagnostic implements IDAODiagnostic{

	@Override
	public void insert(Diagnostic d) {
		DB baseDb=Connexion.getConnex();
		DBCollection collection=baseDb.getCollection("Diagnostic");
		
		ArrayList< DBObject> symptomsArrayList=new ArrayList<DBObject>();
		for(Symptoms s:d.Mysymtoms) {
			DBObject sYSDbObject=new BasicDBObject("designation",s.designation);
			symptomsArrayList.add(sYSDbObject);
		}
			DBObject doc = new BasicDBObject("_idclient",d.MyClient.getId_Client())
					 .append("Mysymtoms", symptomsArrayList)
					 .append("resultat", d.get_possi_presence())
					 .append("date", d.getDate().toString());
					
					 collection.insert(doc);
		
		
		
	}

	@Override
	public void retrive(int id) {
		// TODO Auto-generated method stub
		
	}

}
