package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Site
 *
 */
@Entity

public class Site implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Id
	private int id;
	private String nom;
	private String pays;
	private String ville;
	
	private static final long serialVersionUID = 1L;

	public Site() {
		super();
	}  
	public Site(String nom,String pays,String ville) {
		super();
		this.nom=nom;
		this.pays=pays;
		this.ville=ville;
		
	} 
	


	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPays() {
		return pays;
	}



	public void setPays(String pays) {
		this.pays = pays;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	} 
   
}
