package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity

public class Agent implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String nom;
	private String prenom;
	@NotNull
	@Column(unique=true)
	private String matricule;
	@ManyToOne
	private Site site;
	
	
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}   
	public Agent(String nom,String prenom,String matricule) {
		super();
		this.nom=nom;
		this.prenom=prenom;
		this.matricule=matricule;
		
	} 
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
}
