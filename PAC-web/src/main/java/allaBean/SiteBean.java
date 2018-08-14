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
	private Ville ville;
	private int VilleId;
	private String nom;
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public int getVilleId() {
		return VilleId;
	}
	public void setVilleId(int villeId) {
		VilleId = villeId;
	}
	public List<Site> getAllSites(){
		return ssl.getAllSites();
	}
	public String addSite() {
		ville = ssl.getVilleById(VilleId);
		site= new Site(nom,ville);
		ssl.addSite(site);
		return "done";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String removeSite(Site s) {
		ssl.removeSite(s);
		return s.getNom().concat(" is removed");
	}
}
