package fstm.projet.controller;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import fstm.projet.model.bo.Diagnostic;
import fstm.projet.model.bo.Docteur;
import fstm.projet.model.bo.DroolsTest;
import fstm.projet.model.bo.Socketinter;


public class Serveur {
	
	    public static void main(String[] args) throws Exception
	    {
	        ServerSocket ss = new ServerSocket(7000);
	        System.out.println("ServerSocket awaiting connections...");
	        while(true) {
	        	 Socket socket  = ss.accept();
	        	 synchronized(socket){
	        		 System.out.println("Connection from " + socket);
	        		 	try{
	        		 	        //Deserialization
	        		 	       
	        		 	            InputStream is = socket.getInputStream();
	        		 	            ObjectInputStream ois = new ObjectInputStream(is);
	        		 	            Socketinter socke = (Socketinter) ois.readObject();
	        		               System.out.println(socke.Mysymtoms.toString());
	        		                 Docteur doc =new Docteur(1,"achiban","nourddine");
	        		                 Diagnostic diag=new Diagnostic(1,socke.MyClient,socke.Mysymtoms,doc);
	        		                 
	        		                 System.out.println(diag);
	        		 	            DroolsTest	d= new DroolsTest();	            

	        		 	            //Serialization
	        		 	            double resu=d.Start_Rules(diag);
	        		 	            diag.set_possi_presence(resu);
	        		 	            
	        		 	            OutputStream os = socket.getOutputStream();
	        		 	            ObjectOutputStream oos = new ObjectOutputStream(os);
	        		 	            System.out.println("Sending values to the ServerSocket");
	        		 	           oos.writeObject(resu);
	        		 	           socket.close();
	        	                
	        		 	    

	        		 	    }catch(Exception e){ e.printStackTrace(); }
	        	 }
	 	       
	 	
	        }
	       
}
}
