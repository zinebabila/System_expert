package fstm.projet.model.dao;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import fstm.projet.model.bo.Region;

public class DAORegion implements IDAORegion {

	@Override
	public ArrayList<Region> retreiveR() {
		ArrayList<Region> regions = new ArrayList<Region>();
		DB baseDb=Connexion.getConnex();
		DBCollection collection=baseDb.getCollection("Region");
		DBCursor cursor=collection.find();
		while(cursor.hasNext()) {
			DBObject object=cursor.next();
			try {
				
				JSONObject jsonObject=new JSONObject(JSON.serialize(object));
				Region region=new Region(jsonObject.getString("nom_region"),jsonObject.getInt("_id"));
				region.setNombre_contamines(jsonObject.getInt("nombre_contamines"));
				region.setNombre_deces(jsonObject.getInt("nombre_deces"));
				region.setNombre_geuris(jsonObject.getInt("nombre_geuris")); 
				region.setNombre_habitant(jsonObject.getInt("nombre_habitant"));
				regions.add(region);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return regions;
	}

}
