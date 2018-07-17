package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tracage
 *
 */
@Entity

public class Tracage implements Serializable {

	   
	@Id
	private int id;
	private String type_modif;
	private Date date_modif;
	@OneToOne
	private User user;
	private static final long serialVersionUID = 1L;

	public Tracage() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getType_modif() {
		return this.type_modif;
	}

	public void setType_modif(String type_modif) {
		this.type_modif = type_modif;
	}   
	public Date getDate_modif() {
		return this.date_modif;
	}

	public void setDate_modif(Date date_modif) {
		this.date_modif = date_modif;
	}
   
}
