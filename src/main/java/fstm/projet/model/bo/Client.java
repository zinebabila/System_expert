package fstm.projet.model.bo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;


public class Client implements Serializable {
	int Id_Client;
	String Nom;
	String Prenom;
	int age;
	ArrayList<Diagnostic> diagnostics;
	public int getage() {
	       return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	Boolean Sexe;
	Region region;
	
    double Tempareture;
    Compte cmptCompte;
    Vector<Maladie_chronique> maladies;
    
    
    
    public Compte getCmptCompte() {
		return cmptCompte;
	}
	public void setCmptCompte(Compte cmptCompte) {
		this.cmptCompte = cmptCompte;
	}

	
	public Client(String nom, String prenom, Boolean sexe, Calendar date_naissance,Compte cmp) {
		super();
		diagnostics=new ArrayList<>();
		Nom = nom;
		Prenom = prenom;
		Sexe = sexe;
		int age = -1;
		   Calendar today= Calendar.getInstance();
		 
			if (date_naissance.after(today)==false)
			{	
			
			age = today.get(Calendar.YEAR) - date_naissance.get(Calendar.YEAR);
			}
		this.age=age;
		this.cmptCompte=cmp;
	}
	
	public Client() {
		super();
	}
	
   

	public ArrayList<Diagnostic> getDiagnostics() {
		return diagnostics;
	}
	public void setDiagnostics(ArrayList<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public int getId_Client() {
		return Id_Client;
	}
	public void setId_Client(int id_Client) {
		Id_Client = id_Client;
	}
	public String getNom() {
		return Nom;
	}
	public Vector<Maladie_chronique> getMaladies() {
		return maladies;
	}
	public void setMaladies(Vector<Maladie_chronique> maladies) {
		this.maladies = maladies;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Boolean getSexe() {
		return Sexe;
	}
	public void setSexe(Boolean sexe) {
		Sexe = sexe;
	}
	public double getTempareture() {
		return Tempareture;
	}
	public void setTempareture(double tempareture) {
		Tempareture = tempareture;
	}
	
	
	public Client(int Id_Cl,String N,String Pr,Boolean S,double T,  Region r,Calendar a,String email,String password)
	{
		 Id_Client =Id_Cl;
		 diagnostics=new ArrayList<>();
		 Nom = N;
		 Prenom=Pr;
		 Sexe=S;
		 Tempareture=T;
		 region = r;
		 int age = -1;
		   Calendar today= Calendar.getInstance();
		 
			if (a.after(today)==false)
			{	
			
			age = today.get(Calendar.YEAR) - a.get(Calendar.YEAR);
			}
		this.age=age;
		 cmptCompte=new Compte(email, password);
		 maladies=new Vector<Maladie_chronique>();
		 
	}
	
	public String toString() {
		return  "Nom: "+getNom()+" Prenom :"+getPrenom()+" Age: "+getage();
	}
}