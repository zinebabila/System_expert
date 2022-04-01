package fstm.projet.model.bo;

import java.io.Serializable;
import java.util.Vector;

public class DroolsTest implements Serializable {
	
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
