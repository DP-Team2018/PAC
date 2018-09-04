package Service;

import javax.ejb.Remote;

import entities.Agent;
import entities.Statistiques;

@Remote
public interface StatistiquesServiceRemote {

	public Statistiques findStat(Agent agent);
	public void addStat(Statistiques stat);
	public void updateStat(Statistiques stat);
	public void removeStat(Statistiques stat);
}
