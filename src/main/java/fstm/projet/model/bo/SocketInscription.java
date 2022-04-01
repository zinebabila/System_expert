package fstm.projet.model.bo;

import java.io.Serializable;

public class SocketInscription implements Serializable {
    private String email;
    private String password;

    public SocketInscription(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = String.valueOf(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
