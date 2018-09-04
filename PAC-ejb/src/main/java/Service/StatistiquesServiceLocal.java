package Service;

import javax.ejb.Local;

import entities.Agent;
import entities.Statistiques;

@Local
public interface StatistiquesServiceLocal {
	
	public Statistiques findStat(Agent agent);
	public void addStat(Statistiques stat);
	public void updateStat(Statistiques stat);
	public void removeStat(Statistiques stat);
	
}
