package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Incident
 *
 */
@Entity

public class Incident implements Serializable {

	   
	@Id
	private int id;
	private Date date_incident;
	private String commentaire;
	private String jointe;
	private static final long serialVersionUID = 1L;

	public Incident() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getDate_incident() {
		return this.date_incident;
	}

	public void setDate_incident(Date date_incident) {
		this.date_incident = date_incident;
	}   
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}   
	public String getJointe() {
		return this.jointe;
	}

	public void setJointe(String jointe) {
		this.jointe = jointe;
	}
   
}