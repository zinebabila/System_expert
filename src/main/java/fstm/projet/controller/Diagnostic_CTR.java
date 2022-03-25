package fstm.projet.controller;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import fstm.projet.*;
import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Compte;
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
	

	public Diagnostic_CTR()
	{
		
		 
	}
	public static void charger_dia(Client c) {
		
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
	 new DAOClient().updateDiagnostique(diag,c.getCmptCompte().getEmail() );
	 
		if(d.isEnvoy(doc)==true)
		JOptionPane.showMessageDialog(null, "possibilite de presence : " 
		+ resu*100 + " %100 vous etes une cas d'urgence !! vos informations ont envoyées aux autorités comptétentes",
		"Diagnostic", JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog( null,"possibilite de presence : " 
				+ resu*100 + " %100","Diagnostic", JOptionPane.INFORMATION_MESSAGE);
	 
	 
	 
}

public static ArrayList<Symptoms> afficheSy(){
	DAOSymptom daoSymptom=new DAOSymptom();
	return daoSymptom.retreive();
}
public static ArrayList<Region> afficheRe(){
	DAORegion deDaoRegion=new DAORegion();
	return deDaoRegion.retreiveR();
}
public static void insertClient(String nom,String prenom,Boolean sexe,Calendar date,String email,String password) {
	Compte cmpCompte=new Compte(email, password);
	Client cli=new Client(nom, prenom, sexe, date, cmpCompte);
	DAOClient daoClient=new DAOClient();
	daoClient.insert(cli);
}
public static void updateClient(Client c,double temp,Region reg) {
	DAOClient daoClient=new DAOClient();
	daoClient.updateClient(c, temp, reg);
	charger_dia(c);
	
	
}
public static Client authClient (String email,String passString){
	DAOClient daoClient=new DAOClient();
return daoClient.Authentification(email, passString);
	
}

public static void rempliTable(DefaultTableModel model,Client c) {
	for(Diagnostic diag:c.getDiagnostics()) {
		model.addRow(new String[] {diag.getDate().toString(),""+diag.get_possi_presence()});
		System.out.println(diag);
	}
}

	
}
