package entities;

import entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SuperAdmin
 *
 */
@Entity

public class SuperAdmin  implements Serializable {

	
	private static final long serialVersionUID = 1L;
@Id
int id;
	public SuperAdmin() {
		super();
	}
   
}
