package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Statistiques
 *
 */
@Entity

public class Statistiques implements Serializable {

	   
	@Id
	private int id;
	private double heure_travail;
	private double heure_supp;
	private double absence;
	private double conges;
	@OneToOne
	private Agent agent;
	private static final long serialVersionUID = 1L;

	public Statistiques() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public double getHeure_travail() {
		return this.heure_travail;
	}

	public void setHeure_travail(double heure_travail) {
		this.heure_travail = heure_travail;
	}   
	public double getHeure_supp() {
		return this.heure_supp;
	}

	public void setHeure_supp(double heure_supp) {
		this.heure_supp = heure_supp;
	}   
	public double getAbsence() {
		return this.absence;
	}

	public void setAbsence(double absence) {
		this.absence = absence;
	}   
	public double getConges() {
		return this.conges;
	}

	public void setConges(double conges) {
		this.conges = conges;
	}
   
}
