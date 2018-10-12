package entities;

import entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Responsable
 *
 */
@Entity

public class Responsable  implements Serializable {
	@Id
	private int id;
	@OneToOne
	private Site site;
	@OneToOne
	private Responsable responsable;
	
	private static final long serialVersionUID = 1L;

	public Responsable() {
		super();
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
   
}
