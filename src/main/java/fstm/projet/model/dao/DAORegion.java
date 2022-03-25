package fstm.projet.model.dao;

import com.mongodb.*;
import com.mongodb.util.JSON;

import fstm.projet.model.bo.Region;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DAORegion {
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

        // A faire dans un thread separer chaque heure
        public void updateDatabase() throws JSONException, IOException {
            DB baseDb=Connexion.getConnex();
            DBCollection collection=baseDb.getCollection("Region");
            URL url = new URL("https://services3.arcgis.com/hjUMsSJ87zgoicvl/arcgis/rest/services/Covid_19/FeatureServer/0/query?where=1%3D1&outFields=RegionFr,RegionAr,Cases,Deaths,Recoveries&outSR=4326&f=json");
            InputStream in =  url.openConnection().getInputStream();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
            String name = jsonObject.getString("objectIdFieldName");
            JSONArray arrayRegion = jsonObject.getJSONArray("features");
            for(int i = 0;i<arrayRegion.length();i++) {
                JSONObject o = new JSONObject();
                o = arrayRegion.getJSONObject(i);
                JSONObject oo = o.getJSONObject("attributes");
                BasicDBObject doc = new BasicDBObject();
                doc.append("nombre_contamines",oo.getInt("Cases"));
                doc.append("nombre_deces",oo.getInt("Deaths"));
                doc.append("nombre_habitant",oo.getInt("Recoveries"));
                BasicDBObject newDocument = new BasicDBObject("$set",doc);
                BasicDBObject searchQuery = new BasicDBObject().append("_id", i);
                collection.update(searchQuery,newDocument); 
            }
        }
      

}




