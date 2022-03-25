package fstm.projet.model.bo;

import java.util.Vector;

public class DroolsTest {
	
    public static final void main(String[] args) {

    }
    public double Start_Rules(Diagnostic d) {
    	
    	return d.traiter();
    	
    }
    public boolean isEnvoy(Docteur doc)
    {
    	
    	return doc.isRemplie();
    }
    
  
}
