package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.Flux;

@Remote
public interface FluxServiceRemote {

	public void addFlux(Flux flux);
	public void removeFlux(Flux flux);
	public void updateFlux(Flux flux);
	public List<Flux> findListFlux();
	public List<Flux> findListNotAffected();
}
