package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Prime
 *
 */
@Entity

public class Prime implements Serializable {

	   
	@Id
	private int id;
	private Date date_prime;
	private double valeur;
	@ManyToOne
	private Agent agent;
	
	private static final long serialVersionUID = 1L;

	public Prime() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getDate_prime() {
		return this.date_prime;
	}

	public void setDate_prime(Date date_prime) {
		this.date_prime = date_prime;
	}   
	public double getValeur() {
		return this.valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
   
}
