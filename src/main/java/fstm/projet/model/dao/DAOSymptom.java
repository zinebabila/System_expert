package fstm.projet.model.dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import fstm.projet.model.bo.Region;
import fstm.projet.model.bo.Symptoms;

public class DAOSymptom implements IDAOSymptom {

	@Override
	public void insert(Symptoms s) {
		
	}

	@Override
	public ArrayList<Symptoms> retreive() {
    
		ArrayList<Symptoms> symptoms = new ArrayList<Symptoms>();
		DB baseDb=Connexion.getConnex();
		DBCollection collection=baseDb.getCollection("Symptom");
		DBCursor cursor=collection.find();
		while(cursor.hasNext()) {
			DBObject object=cursor.next();
			try {
				JSONObject jsonObject=new JSONObject(JSON.serialize(object));
				
				symptoms.add(new Symptoms(jsonObject.getString("designation"),jsonObject.getInt("_id")));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return symptoms;
		
		
		
		
	
	}

	
}
