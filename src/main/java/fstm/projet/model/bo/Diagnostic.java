package fstm.projet.model.bo;

import java.io.Serializable;
import java.util.Vector;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Diagnostic implements Serializable {

	    	private int num_diag;
	    	public Vector<Symptoms> Mysymtoms;
	    	private double resultat=0;
	    	public Client MyClient;
	    	public Docteur d;
	    	public Diagnostic(int id , Client c) {
	    		num_diag=id;
	    		this.Mysymtoms = new Vector<Symptoms>();
	    		this.MyClient=c;
	    		
	    	}
	    	public Diagnostic(int id , Client c, Vector<Symptoms> sy, Docteur f) {
	    		num_diag=id;
	    		this.Mysymtoms = sy;
	    		this.MyClient=c;
	    		this.d=f;
	    	}
	    	
	    	public double get_possi_presence()
	    	{
	    		return resultat;
	    	}
	    	public void set_possi_presence(double r)
	    	{
	    		 resultat = r;
	    	}
	    	public void ajouter( Symptoms S) {
	    		Mysymtoms.add(S);
	    	}
	    	public void S( Symptoms S) {
	    		Mysymtoms.add(S);
	    	}
	    	public double traiter()
	    	{
	    		 try {
	    	            // load up the knowledge base
	    		        KieServices ks = KieServices.Factory.get();
	    	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	    	        	KieSession kSession = kContainer.newKieSession("ksession-rules");
	    	            kSession.insert(this);
	    	            kSession.fireAllRules();
	    		 }
	    		 catch (Throwable t) {
	    	            t.printStackTrace();
	    	        }
	    		
	    		return resultat; 
	    	}
	    	public void envoyer() {
	    		d.setRemplie(true);
	    		d.setMsg("Ce patient est une cas d'urgent voici ces informations"+MyClient);
	    		
	    	}
	    	public String toString() {
	    		return Mysymtoms.toString();
	    	}
	    
}
