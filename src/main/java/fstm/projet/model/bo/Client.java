package fstm.projet.model.bo;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;


public class Client implements Serializable {
	int Id_Client;
	String Nom;
	String Prenom;
	int age;
	public int getage() {
		int age = -1;
		   Calendar today= Calendar.getInstance();
		 
			if (date_naissance.after(today)==false)
			{	
			
			age = today.get(Calendar.YEAR) - date_naissance.get(Calendar.YEAR);
			}
	      
	   	
		  return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	Boolean Sexe;
	Region region;
	Calendar date_naissance;
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
		Nom = nom;
		Prenom = prenom;
		Sexe = sexe;
		this.date_naissance = date_naissance;
		this.cmptCompte=cmp;
	}
	public Calendar getDate_naissance() {
		return date_naissance;
	}
	public Client() {
		super();
	}
	public void setDate_naissance(Calendar   date_naissance) {
		this.date_naissance = date_naissance;
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
		 Nom = N;
		 Prenom=Pr;
		 Sexe=S;
		 Tempareture=T;
		 region = r;
		 date_naissance=a;
		 cmptCompte=new Compte(email, password);
		 maladies=new Vector<Maladie_chronique>();
		 
	}
	
	public String toString() {
		return  "Nom: "+getNom()+" Prenom :"+getPrenom()+" Age: "+getage();
	}
}