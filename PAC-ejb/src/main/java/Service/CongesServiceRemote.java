package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.Conges;

@Remote
public interface CongesServiceRemote {

	public List<Conges> findAllConges();
}
