package fstm.projet.model.bo;

import java.io.Serializable;

public class Docteur implements Serializable  {
	int Id_Doc;
	String Nom;
	String Prenom;
	String Msg=null;
	boolean remplie;
	
	public String getMsg() {
		return Msg;
	}
	public Docteur(int d,String n,String p) {
		Id_Doc=d;
		Nom=n;
		Prenom=p;
		remplie=false;
	}
	
	public boolean isRemplie() {
		return remplie;
	}
	public void setRemplie(boolean remplie) {
		this.remplie = remplie;
	}
	public void setMsg(String msg) {
		Msg=msg;
		remplie=true;
		System.out.println(Msg);
	}
}
