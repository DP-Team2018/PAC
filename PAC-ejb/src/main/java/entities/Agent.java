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

public class Agent  implements Serializable {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String nom;
	private String prenom;
	@NotNull
	@Column(unique=true)
	private String matricule;
	@ManyToOne
	private Site site;
	
	private String contrat;
	private int nbreHeure;
	
	
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}   
	public Agent(String nom,String prenom,String matricule,Site site,int nbreHeure) {
		super();
		this.nom=nom;
		this.prenom=prenom;
		this.matricule=matricule;
		this.site=site;
		this.nbreHeure=nbreHeure;
		
	} 
	
	
	public Agent(int id, String nom, String prenom, String matricule, Site site, String contrat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.site = site;
		this.contrat = contrat;
		
	}
	public Agent(String nom, String prenom, String matricule, Site site, String contrat) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.site = site;
		this.contrat = contrat;
		
	}
	public Agent(String nom, String prenom, String matricule, Site site) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.site = site;
		
		
	}
	
	
	public Agent(int id, String nom, String prenom, String matricule, Site site, String contrat, int nbreHeure) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.site = site;
		this.contrat = contrat;
		this.nbreHeure = nbreHeure;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public String getContrat() {
		return contrat;
	}
	public void setContrat(String contrat) {
		this.contrat = contrat;
	}
	public int getNbreHeure() {
		return nbreHeure;
	}
	public void setNbreHeure(int nbreHeure) {
		this.nbreHeure = nbreHeure;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
