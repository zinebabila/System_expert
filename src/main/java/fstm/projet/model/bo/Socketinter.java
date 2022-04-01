package fstm.projet.model.bo;

import java.io.Serializable;
import java.util.Vector;

public class Socketinter implements Serializable {
public Vector<Symptoms> Mysymtoms;
	
	public Client MyClient;

	public Socketinter( Vector<Symptoms> sympo, Client Clie) {
		 Mysymtoms=sympo;
		 MyClient=Clie;
		
	}

	@Override
	public String toString() {
		return "Socketinter{" +
				"Mysymtoms=" + Mysymtoms +
				", MyClient=" + MyClient +
				'}';
	}

	
}
