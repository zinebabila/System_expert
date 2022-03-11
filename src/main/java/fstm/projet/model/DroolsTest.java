package fstm.projet.model;

import java.util.Vector;

public class DroolsTest {
	Docteur doc;
    public static final void main(String[] args) {

    }
    public double Start_Rules(Diagnostic d) {
    	
    	return d.traiter();
    	
    }
    public boolean isEnvoy()
    {
    	return doc.isRemplie();
    }
    
  
}
