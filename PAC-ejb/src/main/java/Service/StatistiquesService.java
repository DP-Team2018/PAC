package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Agent;
import entities.Flux;
import entities.Statistiques;

/**
 * Session Bean implementation class StatistiquesService
 */
@Stateless
@LocalBean
public class StatistiquesService implements StatistiquesServiceRemote, StatistiquesServiceLocal {

    @PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public StatistiquesService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Statistiques findStat(Agent agent) {
		return em.createQuery("select s from Statistiques s where s.agent=:agent",Statistiques.class).setParameter("agent", agent).getSingleResult();
	}

	@Override
	public void addStat(Statistiques stat) {
		em.persist(stat);
		
	}

	@Override
	public void updateStat(Statistiques stat) {
		em.merge(stat);
		
	}

	@Override
	public void removeStat(Statistiques stat) {
		em.remove(em.merge(stat));
		
	}
	

}
