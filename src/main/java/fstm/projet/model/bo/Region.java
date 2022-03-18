package fstm.projet.model.bo;

import java.io.Serializable;

public class Region implements Serializable  {
 private int id_RE;
 private String nom_region;
 private int nombre_deces;
 private int nombre_geuris;
 private int nombre_contamines;
 private int nombre_habitant;
 public boolean haut_risque() {
	 
	 double niveau=nombre_contamines*100000/nombre_habitant;
	 
	 return (niveau>=500);
 }
 public Region(String string, int i)
 {
	 nom_region=string; 
	 id_RE=i;
 }
 public String toString()
 {
	 return nom_region;
 }
 public Region()
 {	 
	
 }
public int getId_RE() {
	return id_RE;
}
public void setId_RE(int id_RE) {
	this.id_RE = id_RE;
}
public String getNom_region() {
	return nom_region;
}
public void setNom_region(String nom_region) {
	this.nom_region = nom_region;
}
public int getNombre_deces() {
	return nombre_deces;
}
public void setNombre_deces(int nombre_deces) {
	this.nombre_deces = nombre_deces;
}
public int getNombre_geuris() {
	return nombre_geuris;
}
public void setNombre_geuris(int nombre_geuris) {
	this.nombre_geuris = nombre_geuris;
}
public int getNombre_contamines() {
	return nombre_contamines;
}
public void setNombre_contamines(int nombre_contamines) {
	this.nombre_contamines = nombre_contamines;
}
public int getNombre_habitant() {
	return nombre_habitant;
}
public void setNombre_habitant(int nombre_habitant) {
	this.nombre_habitant = nombre_habitant;
}
}
