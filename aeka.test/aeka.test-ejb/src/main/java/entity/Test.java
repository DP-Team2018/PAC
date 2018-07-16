package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Test
 *
 */
@Entity

public class Test implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	int id;
	String test;

	public Test() {
		super();
	}
   
}
