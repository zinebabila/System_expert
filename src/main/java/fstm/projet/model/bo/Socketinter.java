package fstm.projet.model.bo;

import java.io.Serializable;
import java.util.Vector;
public class Socketinter implements Serializable {
    public final double temperaturee;
    public final Region region;
    public Vector<Symptoms> Mysymtoms;
    public Vector<Maladie_chronique> mald;

    public Client MyClient;

    public Socketinter(Vector<Symptoms> sympo, Client Clie, double temperature, Region r, Vector<Maladie_chronique> mal) {
        Mysymtoms = sympo;
        MyClient = Clie;
        temperaturee = temperature;
        region = r;
        mald = mal;
    }

    @Override
    public String toString() {
        return "Socketinter{" +
                "Mysymtoms=" + Mysymtoms +
                ", MyClient=" + MyClient +
                '}';
    }


}
