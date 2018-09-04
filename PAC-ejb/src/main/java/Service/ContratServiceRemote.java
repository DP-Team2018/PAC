package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.Contrat;

@Remote
public interface ContratServiceRemote {

	public List<Contrat> findAllContrat();
	public void addContrat(Contrat contrat);
	public void deleteContrat(Contrat contrat);
	public void updateContrat(Contrat contrat);
}
