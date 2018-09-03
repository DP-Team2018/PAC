package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mission
 *
 */
@Entity

public class Mission implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String etat;
	private Date date_mission;
	@OneToOne
	private Affectation affectation;
	@OneToOne
	private Agent agent;
	
	private static final long serialVersionUID = 1L;

	public Mission() {
		super();
	}   
	
	public Mission(String etat, Date date_mission, Affectation affectation, Agent agent) {
		super();
		this.etat = etat;
		this.date_mission = date_mission;
		this.affectation=affectation;
		this.agent = agent;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}   
	public Date getDate_mission() {
		return this.date_mission;
	}

	public void setDate_mission(Date date_mission) {
		this.date_mission = date_mission;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Affectation getAffectation() {
		return affectation;
	}

	public void setAffectation(Affectation affectation) {
		this.affectation = affectation;
	}
   
}
