package fstm.projet.model.bo;

import java.io.Serializable;

public class Compte implements Serializable {
private String Email;
private String password;

public Compte() {
	super();
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return password;
}
public Compte(String email, String password) {
	super();
	Email = email;
	this.password = password;
}
public void setPassword(String password) {
	this.password = password;
}

}
