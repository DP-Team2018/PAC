package allaBean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import Service.SiteService;
import Service.SiteServiceLocal;
import entities.Pays;
import entities.Site;
import entities.Ville;



@ManagedBean
@RequestScoped
public class SiteBean {
	@EJB
	SiteServiceLocal ssl;
	@EJB
	SiteService ss;
	private Site site;
	private List<Site> sites;
	private String nom;
	private Pays pays;
	private Ville ville;
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

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
	public String addSite() {
		site = new Site(nom,pays,ville);
		ssl.addSite(site);
		System.out.println(site.getNom().concat(" ").concat(pays.getNom()).concat(" ").concat(ville.getNom()));
		return site.getNom().concat(" ").concat(pays.getNom()).concat(" ").concat(ville.getNom()).concat(" est ajouter");
	}
	public List<Site> getAllSites(){
		return ssl.getAllSites();
	}
	

}
