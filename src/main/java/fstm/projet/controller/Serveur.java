package fstm.projet.controller;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import fstm.projet.model.Diagnostic;
import fstm.projet.model.DroolsTest;


public class Serveur {
	
	    public static void main(String[] args) throws Exception
	    {
	        ServerSocket ss = new ServerSocket(7000);
	        System.out.println("ServerSocket awaiting connections...");
	        Socket socket = ss.accept();
	        System.out.println("Connection from " + socket);
	try{
	        //Deserialization
	        while (true){
	            InputStream is = socket.getInputStream();
	            ObjectInputStream ois = new ObjectInputStream(is);
	            Diagnostic diag = (Diagnostic) ois.readObject();


	            DroolsTest	d= new DroolsTest();	            

	            System.out.println("Closing sockets.");
	            //Serialization
	            double resu=d.Start_Rules(diag);
	            
	            OutputStream os = socket.getOutputStream();
	            ObjectOutputStream oos = new ObjectOutputStream(os);
	            System.out.println("Sending values to the ServerSocket");
	            oos.writeObject(resu);

	        }

	    }catch(Exception ignored){ }
}
}
