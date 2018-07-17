package entities;

import entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Responsable
 *
 */
@Entity

public class Responsable extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Responsable() {
		super();
	}
   
}
