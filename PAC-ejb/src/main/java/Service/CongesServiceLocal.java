package Service;

import java.util.List;

import javax.ejb.Local;

import entities.Conges;

@Local
public interface CongesServiceLocal {

	public List<Conges> findAllConges();
}
