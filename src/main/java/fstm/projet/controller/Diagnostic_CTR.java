package fstm.projet.controller;

import java.util.Vector;

import fstm.projet.*;

import fstm.projet.model.Client;
import fstm.projet.model.Diagnostic;
import fstm.projet.model.Docteur;
import fstm.projet.model.DroolsTest;
import fstm.projet.model.Maladie_chronique;
import fstm.projet.model.Symptoms;
import fstm.projet.view.Acueil;

public class Diagnostic_CTR {
	Client client;
	public Diagnostic_CTR(Client c)
	{
		client=c;
		
		Acueil fram1= new Acueil(c);
		fram1.setVisible(true);
		
		 
	}
	
static void diagoniser(Client c,Vector<Symptoms> sys,Vector<Maladie_chronique> mal) {
	Docteur doc=new Docteur(1,"alami","ahmed");
 	
	 DroolsTest	d= new DroolsTest();
	 c.setMaladies(mal);
	 Diagnostic diag = new Diagnostic(1,c,sys,doc);
	 
	 double resu=d.Start_Rules(diag);
	 Acueil.Resul.setText(resu*100 + " %100");
	 
	 
	 
	 
	 
		/*if(d.isEnvoy()==true)
		JOptionPane.showMessageDialog(jButton4, "possibilite de presence : " 
		+ resu*100 + " %100 vous etes une cas d'urgence !! vos informations ont envoyées aux autorités comptétentes",
		"Diagnostic", JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog(jButton4, "possibilite de presence : " 
				+ resu*100 + " %100","Diagnostic", JOptionPane.INFORMATION_MESSAGE);*/
	 
	 
	 
}
	
	
}
