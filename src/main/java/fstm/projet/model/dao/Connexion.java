package fstm.projet.model.dao;
import java.net.UnknownHostException;

import com.mongodb.*;


public class Connexion {

	public static DB getConnex() {
		DB baseDb=null;
		try {
			MongoClient client=new MongoClient("localhost",27017);
			
			 baseDb=client.getDB("DBDiagnostic");
			
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseDb;
		
	}
}
