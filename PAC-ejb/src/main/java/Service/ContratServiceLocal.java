package Service;

import java.util.List;

import javax.ejb.Local;
import entities.Contrat;

@Local
public interface ContratServiceLocal {

	public List<Contrat> findAllContrat();
	public void addContrat(Contrat contrat);
	public void deleteContrat(Contrat contrat);
	public void updateContrat(Contrat contrat);
}
