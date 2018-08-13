package Service;

import java.util.List;

import javax.ejb.Local;

import entities.Affectation;

@Local
public interface AffectationServiceLocal {

	public void addAffectation(Affectation affect);
	public void deleteAffectation(Affectation affect);
	public void updateAffectation(Affectation affect);
	public List<Affectation> findListAffectation();
}
