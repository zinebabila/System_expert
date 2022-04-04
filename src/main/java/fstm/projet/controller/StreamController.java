package fstm.projet.controller;

import java.io.IOException;

import org.json.JSONException;

import fstm.projet.model.dao.DAORegion;

public class StreamController extends Thread {

    @Override
    public void run() {
    	while(true) {
        try {
            new DAORegion().updateDatabase();
            System.out.println("Update done, let's sleep");
            sleep(86400000);// 24 heurs
        } catch (JSONException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }}
}
