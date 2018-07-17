package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Absence
 *
 */
@Entity

public class Absence implements Serializable {

	   
	@Id
	private int id;
	private Date date_absence;
	@ManyToOne
	private Agent agent;
	private static final long serialVersionUID = 1L;

	public Absence() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getDate_absence() {
		return this.date_absence;
	}

	public void setDate_absence(Date date_absence) {
		this.date_absence = date_absence;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
   
}
