package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flux
 *
 */
@Entity

public class Flux implements Serializable {

	   
	@Id
	private int id;
	private double charge_horaire;
	@OneToMany
	private List<Agent> agents;
	private static final long serialVersionUID = 1L;

	public Flux() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public double getCharge_horaire() {
		return this.charge_horaire;
	}

	public void setCharge_horaire(double charge_horaire) {
		this.charge_horaire = charge_horaire;
	}
   
}
