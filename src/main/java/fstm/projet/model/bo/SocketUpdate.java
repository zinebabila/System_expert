package fstm.projet.model.bo;

import java.io.Serializable;

public class SocketUpdate implements Serializable {
    private Client client;
    double temp;
    Region reg;

    public SocketUpdate(Client client, double temp, Region reg) {
        this.client = client;
        this.temp = temp;
        this.reg = reg;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Region getReg() {
        return reg;
    }

    public void setReg(Region reg) {
        this.reg = reg;
    }
}

