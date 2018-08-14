package allaBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Service.SiteService;
import Service.SiteServiceLocal;
import entities.Pays;
import entities.Ville;

@ManagedBean
@RequestScoped
public class VilleBean {
	@EJB
	SiteServiceLocal ssl;
	@EJB
	SiteService ss;
	private String nom;
	private Pays pays;
	private int paysId;
	private Ville ville;

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String addVille(){
		pays=ssl.getPaysByID(paysId);
		ville= new Ville(nom,pays);
		ssl.addVille(ville);
		return ville.getNom();
	}
	public List<Ville> getAllVilles(){
		return ssl.getAllVilles();
	}

	public int getPaysId() {
		return paysId;
	}

	public void setPaysId(int paysId) {
		this.paysId = paysId;
	}
	
	public List<Ville> getAllVillesByPays(){
		pays = new Pays();
		pays = ssl.getPaysByID(paysId);
		return ssl.getVillesByPays(pays);
	}
	public List<Ville> getAllVillesByPaysId(int id){
		pays = new Pays();
		pays = ssl.getPaysByID(id);
		return ssl.getVillesByPays(pays);
	}
	public String removeVille(Ville v) {
		ssl.removeVille(v);
		return v.getNom().concat(" is removed");
	}
}
