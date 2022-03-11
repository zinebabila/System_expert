package fstm.projet.model;

public class Maladie_chronique {
	int id_maladie;
	String nom;
	public int getId_maladie() {
		return id_maladie;
	}
	public void setId_maladie(int id_maladie) {
		this.id_maladie = id_maladie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
public Maladie_chronique(int id,String n){
	id_maladie=id;
	nom=n;
}
}
