package fstm.projet.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Diagnostic;
import fstm.projet.model.bo.Docteur;
import fstm.projet.model.bo.DroolsTest;
import fstm.projet.model.bo.Region;
import fstm.projet.model.bo.SocketInscription;
import fstm.projet.model.bo.SocketUpdate;
import fstm.projet.model.bo.Socketinter;
import fstm.projet.model.bo.Symptoms;
import fstm.projet.model.dao.DAOClient;
import fstm.projet.model.dao.DAODiagnostic;
import fstm.projet.model.dao.DAORegion;
import fstm.projet.model.dao.DAOSymptom;

public class SocketController implements Runnable {
    private Socket socket;
    private InputStream is;
    private ObjectInputStream ois;
    private OutputStream os;
    private ObjectOutputStream oos;

    public SocketController(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            Object objInput = ois.readObject();
            if (objInput instanceof Client socke) {
                insertionClient(socke);
            } else if (objInput instanceof SocketInscription socke) {
                verifieClient(socke);
            } else if (objInput instanceof Socketinter socke) {
                System.out.println("Traiting socketintern.................");
                diagoniser(socke);
            }/*else if(objInput instanceof SocketUpdate socke){
                ClientUpdate(socke);
            }*/ else if (objInput instanceof Symptoms) {
                sendSymptoms();
            } else if (objInput instanceof Region) {
                sendRegions();
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();

        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void insertionClient(Client socke) {
        System.out.println("Receiving socket inscription");
        DAOClient daoClient = new DAOClient();
        daoClient.insert(socke);
        System.out.println("Bien inserer");
    }

    private void sendRegions() throws IOException {
        DAORegion daoSymptom = new DAORegion();
        os = socket.getOutputStream();
        oos = new ObjectOutputStream(os);
        System.out.println("Sending values to the ServerSocket");
        oos.writeObject(daoSymptom.retreiveR());
    }

    private void sendSymptoms() throws IOException {
        DAOSymptom daoSymptom = new DAOSymptom();
        os = socket.getOutputStream();
        oos = new ObjectOutputStream(os);
        oos.writeObject(daoSymptom.retreive());
    }

    /*private void ClientUpdate(SocketUpdate socke) {
        DAOClient daoClient=new DAOClient();
        daoClient.updateClient(socke.getClient(),socke.getTemp(),socke.getReg());
        System.out.println("Bien appdate");
    }*/

    private void diagoniser(Socketinter socke) throws IOException {
        DroolsTest d = new DroolsTest();
        System.out.println(socke.Mysymtoms.toString());
        Docteur doc = new Docteur(1, "achiban", "nourddine");
        // new DAOClient().updateMaladie(socke.mald, socke.MyClient.getCmptCompte().getEmail());

        Diagnostic diag = new Diagnostic(1, socke.MyClient, socke.Mysymtoms, doc);
        diag.setTemperature(socke.temperaturee);
        diag.setRegion(socke.region);
        diag.setMaladies(socke.mald);

        System.out.println(diag);
        System.out.println(diag.MyClient);
        System.out.println(diag.getMaladies());


        //Serialization
        double resu = d.Start_Rules(diag);
        System.out.println(resu);
        String message;
        diag.set_possi_presence(resu);
        new DAOClient().updateDiagnostique(diag, socke.MyClient.getCmptCompte().getEmail());
        //new DAODiagnostic().insert(diag);
        os = socket.getOutputStream();
        oos = new ObjectOutputStream(os);
        System.out.println("Sending values to the ServerSocket");
        if (d.isEnvoy(doc)) {
            message = "possibilite de presence : " + resu * 100 + " %100 vous etes une cas d'urgence !! vos informations ont envoyes aux autorits compttentes" + "Diagnostic";
        } else {
            message = "possibilite de presence : " + resu * 100 + " %100";
        }
        oos.writeObject(message);
    }

    private void verifieClient(SocketInscription socke) throws IOException {
        System.out.println(socke.getEmail());
        DAOClient daoClient = new DAOClient();
        Client b = daoClient.Authentification(socke.getEmail(), socke.getPassword());
        os = socket.getOutputStream();
        oos = new ObjectOutputStream(os);
        System.out.println("Sending values to the ServerSocket");
        oos.writeObject(b);
    }
}