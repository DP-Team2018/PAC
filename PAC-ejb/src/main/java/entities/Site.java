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

	   
	@Id
	private Date id;
	private String nom;
	private static final long serialVersionUID = 1L;

	public Site() {
		super();
	}   
	public Date getId() {
		return this.id;
	}

	public void setId(Date id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
   
}
