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
import entities.Site;



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
	private String pays;
	private String ville;
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
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}
	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String addSite() {
		site = new Site(nom,pays,ville);
		ssl.addSite(site);
		System.out.println(site.getNom().concat(" ").concat(site.getPays()).concat(" ").concat(site.getVille()));
		return site.getNom().concat(" ").concat(site.getPays()).concat(" ").concat(site.getVille()).concat(" est ajouter");
	}
	public List<Site> getAllSites(){
		return ssl.getAllSites();
	}
	

}
