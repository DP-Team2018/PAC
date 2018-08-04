package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Affectation
 *
 */
@Entity

public class Affectation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date date_debut;
	private Date date_fin;
	@OneToMany
	private List<Flux> flux;
	
	private static final long serialVersionUID = 1L;

	public Affectation() {
		super();
	}   
	
	public Affectation(List<Flux> flux) {
		super();
		this.flux = flux;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getDate_debut() {
		return this.date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}   
	public Date getDate_fin() {
		return this.date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public List<Flux> getFlux() {
		return flux;
	}
	public void setFlux(List<Flux> flux) {
		this.flux = flux;
	}
   
}
