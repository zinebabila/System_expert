package fstm.projet.model.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
	    	private LocalDate date;
	    	
			public LocalDate getDate() {
				return date;
			}
			public void setDate(LocalDate date) {
				this.date = date;
			}
			public Diagnostic(int id , Client c) {
	    		num_diag=id;
	    		this.Mysymtoms = new Vector<Symptoms>();
	    		this.MyClient=c;
	    		
	    		
	    	}
	    	public Diagnostic(Vector<Symptoms> symptoms,double res,Client c,LocalDate date) {
	    		Mysymtoms=symptoms;
	    		resultat=res;
	    		MyClient=c;
	    		this.date=date;
	    		
	    	}
	    	public int getNum_diag() {
				return num_diag;
			}
			public void setNum_diag(int num_diag) {
				this.num_diag = num_diag;
			}
			public Vector<Symptoms> getMysymtoms() {
				return Mysymtoms;
			}
			public void setMysymtoms(Vector<Symptoms> mysymtoms) {
				Mysymtoms = mysymtoms;
			}
			public Client getMyClient() {
				return MyClient;
			}
			public void setMyClient(Client myClient) {
				MyClient = myClient;
			}
			public Docteur getD() {
				return d;
			}
			public void setD(Docteur d) {
				this.d = d;
			}
			public double getResultat() {
				return resultat;
			}
			public void setResultat(double resultat) {
				this.resultat = resultat;
			}
			public Diagnostic(int id , Client c, Vector<Symptoms> sy, Docteur f) {
	    		num_diag=id;
	    		this.Mysymtoms = sy;
	    		this.MyClient=c;
	    		this.d=f;
	    		this.date=LocalDate.now();
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
	    	@Override
			public String toString() {
				return "Diagnostic [num_diag=" + num_diag + ", Mysymtoms=" + Mysymtoms + ", resultat=" + resultat + "]";
			}
	    
}
