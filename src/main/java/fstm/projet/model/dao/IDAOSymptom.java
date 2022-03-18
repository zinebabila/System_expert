package fstm.projet.model.dao;

import java.util.ArrayList;

import fstm.projet.model.bo.Region;
import fstm.projet.model.bo.Symptoms;

public interface IDAOSymptom {
	public void insert(Symptoms s);
	public ArrayList<Symptoms> retreive();
	

}
