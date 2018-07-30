package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idUser;
	private String nom;
	private String prenom;
	private String role;
	private String password;
	private String email;
	
	
	
	public User() {
		super();
		
	}
	
	public User(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

   
}
