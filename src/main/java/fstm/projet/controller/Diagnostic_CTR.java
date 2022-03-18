package fstm.projet.controller;

import java.util.ArrayList;
import java.util.Vector;

import fstm.projet.*;
import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Diagnostic;
import fstm.projet.model.bo.Docteur;
import fstm.projet.model.bo.DroolsTest;
import fstm.projet.model.bo.Maladie_chronique;
import fstm.projet.model.bo.Region;
import fstm.projet.model.bo.Symptoms;
import fstm.projet.model.dao.DAOClient;
import fstm.projet.model.dao.DAODiagnostic;
import fstm.projet.model.dao.DAORegion;
import fstm.projet.model.dao.DAOSymptom;
import fstm.projet.view.Acueil;

public class Diagnostic_CTR {
	
	Client client;
	public Diagnostic_CTR(Client c)
	{
		client=c;
		
		Acueil fram1= new Acueil(c);
		fram1.setVisible(true);
		
		 
	}
	
public static void diagoniser(Client c,Vector<Symptoms> sys,Vector<Maladie_chronique> mal) {
	Docteur doc=new Docteur(1,"alami","ahmed");
 	
	 DroolsTest	d= new DroolsTest();
	 c.setMaladies(mal);
	 new DAOClient().updateMaladie(mal, c.getCmptCompte().getEmail());
	 
	 Diagnostic diag = new Diagnostic(1,c,sys,doc);
	 
	 double resu=d.Start_Rules(diag);
	 diag.set_possi_presence(resu);
	 Acueil.Resul.setText(resu*100 + " %100");
	 new DAODiagnostic().insert(diag);
	 
	 
	 
	 
	 
		/*if(d.isEnvoy()==true)
		JOptionPane.showMessageDialog(jButton4, "possibilite de presence : " 
		+ resu*100 + " %100 vous etes une cas d'urgence !! vos informations ont envoyées aux autorités comptétentes",
		"Diagnostic", JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog(jButton4, "possibilite de presence : " 
				+ resu*100 + " %100","Diagnostic", JOptionPane.INFORMATION_MESSAGE);*/
	 
	 
	 
}

public static ArrayList<Symptoms> afficheSy(){
	DAOSymptom daoSymptom=new DAOSymptom();
	return daoSymptom.retreive();
}
public static ArrayList<Region> afficheRe(){
	DAORegion deDaoRegion=new DAORegion();
	return deDaoRegion.retreiveR();
}
public static void insertClient(Client cli) {
	DAOClient daoClient=new DAOClient();
	daoClient.insert(cli);
}




	
}
