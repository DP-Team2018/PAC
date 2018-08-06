package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Affectation;

/**
 * Session Bean implementation class AffectationService
 */
@Stateless
@LocalBean
public class AffectationService implements AffectationServiceRemote, AffectationServiceLocal {

    @PersistenceContext
	private EntityManager em;
    
    /**
     * Default constructor. 
     */
    public AffectationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAffectation(Affectation affect) {
		em.persist(affect);
		
	}

	@Override
	public void deleteAffectation(Affectation affect) {
		em.remove(affect);
		
	}

	@Override
	public void updateAffectation(Affectation affect) {
		em.merge(affect);
		
	}
	public void test()
	{
		System.out.println("test worked");
	}

	@Override
	public List<Affectation> findListAffectation() {
		return em.createQuery("select f from Affectation f",Affectation.class).getResultList();
	}

}
