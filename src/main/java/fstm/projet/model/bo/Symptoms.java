package fstm.projet.model.bo;

import java.io.Serializable;

public class Symptoms implements Serializable  {
    	public String designation;
    	public int id_Sym;
    
    	public Symptoms(String n , int I) {
    		designation=n;
    		id_Sym=I;
    	}
    	public String toString()
    	{
    		return designation;
    	}

    	

}
