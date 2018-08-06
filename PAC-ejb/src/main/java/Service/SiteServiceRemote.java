package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.Site;

@Remote
public interface SiteServiceRemote {
	public List<Site> getAllSites();
	public void addSite(Site s);
	public Site getSiteByID(int id);
	public List<Site> getSitesByPays(String pays);
	public List<Site> getSitesByVille(String ville);
	public void removeSite(Site s);
	public void update(Site s);
}
