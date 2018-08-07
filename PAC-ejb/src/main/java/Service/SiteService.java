package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Site;

/**
 * Session Bean implementation class SiteService
 */
@Stateless
@LocalBean
public class SiteService implements SiteServiceRemote, SiteServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public SiteService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Site> getAllSites() {
		return em.createQuery("SELECT s from Site s",Site.class).getResultList();
	}

	@Override
	public void addSite(Site s) {
		em.persist(s);
		
	}

	@Override
	public Site getSiteByID(int id) {
		return em.find(Site.class, id);
	}

	@Override
	public List<Site> getSitesByPays(String pays) {
		return em.createQuery("SELECT s form Site s where s.pays=:pays",Site.class).setParameter("pays", pays).getResultList();
	}

	@Override
	public List<Site> getSitesByVille(String ville) {
	return em.createQuery("SELECT s form Site s where s.ville=:ville",Site.class).setParameter("ville", ville).getResultList();
	}

	@Override
	public void removeSite(Site s) {
		em.remove(s);
		
	}

	@Override
	public void update(Site s) {
		em.merge(s);
		
	}

	@Override
	public List<String> getAllPays() {
		return em.createQuery("SELECT pays form Site s GROUP BY pays",String.class).getResultList();
	}

	@Override
	public List<String> getVillesByPays(String pays) {
		return em.createQuery("SELECT ville form Site s where s.pays=:pays",String.class).setParameter("pays", pays).getResultList();
	}

}
