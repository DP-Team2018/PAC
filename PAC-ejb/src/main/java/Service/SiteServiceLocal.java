package Service;

import java.util.List;

import javax.ejb.Local;

import entities.Pays;
import entities.Site;
import entities.Ville;

@Local
public interface SiteServiceLocal {
	public List<Site> getAllSites();
	public void addSite(Site s);
	public Site getSiteByID(int id);
	public List<Site> getSitesByPays(Pays pays);
	public List<Site> getSitesByVille(Ville ville);
	public void removeSite(Site s);
	public void update(Site s);
	public void addPays(Pays p);
	public Pays getPaysByID(int id);
	public void updatePays(Pays p);
	public void  removePays(Pays p);
	public List<Pays> getAllPays();
	public void addVille(Ville v);
	public Ville getVilleById(int id);
	public void updateVille(Ville v);
	public void removeVille(Ville v);
	public List<Ville> getAllVilles();
	public List<Ville> getVillesByPays(Pays p);
	

}
