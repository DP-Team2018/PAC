package allaBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Service.SiteService;
import Service.SiteServiceLocal;
import entities.Pays;

@ManagedBean
@RequestScoped
public class PaysBean {
	@EJB
	SiteServiceLocal ssl;
	@EJB
	SiteService ss;
	private String nom;
	private Pays pays;
	private List<Pays> lesPays;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String addPays() {
		pays= new Pays(nom);
		ssl.addPays(pays);
		return pays.getNom();
	
	}
	public List<Pays> getAllPays(){
		return ssl.getAllPays();
	}

	public List<Pays> getLesPays() {
		return lesPays;
	}

	public void setLesPays(List<Pays> lesPays) {
		this.lesPays = lesPays;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays=pays;
	}
	public String removePays(Pays p) {
		ssl.removePays(p);
		return p.getNom().concat(" is deleted");
	}
}
