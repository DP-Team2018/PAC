package allaBean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import Service.SiteService;
import Service.SiteServiceLocal;
import entities.Pays;
import entities.Site;
import entities.Ville;



@ManagedBean
@ViewScoped
public class SiteBean {
	@EJB
	SiteServiceLocal ssl;
	@EJB
	SiteService ss;
	private Site site;
	private Ville ville;
	private int villeId;
	private String nom;
	private Site selected;
	private boolean selection;
	
	
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public int getVilleId() {
		return villeId;
	}
	public void setVilleId(int villeId) {
		this.villeId = villeId;
	}
	public List<Site> getAllSites(){
		return ssl.getAllSites();
	}
	public String addSite() {
		ville = ssl.getVilleById(villeId);
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
	public List<Site> getSitesByVilleId(int id){
		ville= ssl.getVilleById(id);
		return ssl.getSitesByVille(ville);
	}
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	
	public String selectSite (Site s) {
		this.selected=s;
	    this.nom=s.getNom();
	    this.ville=s.getVille();
		System.out.println(s.getNom());
		this.selection=true;
		return s.getNom().concat(" si selected.");
	}
	public String unSelectSite() {
		this.selected=new Site();
	    this.nom="";
	    this.ville=new Ville();
	    this.villeId=0;
		this.selection=false;
		return "unselection";
	}
	public String updateSite () {
		ville=ssl.getVilleById(villeId);
		this.selected.setNom(this.nom);
		this.selected.setVille(this.ville);;
		ssl.updateSite(this.selected);
		return "updated";
	}
	
	
}
