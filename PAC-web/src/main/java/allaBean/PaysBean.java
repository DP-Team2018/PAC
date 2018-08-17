package allaBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.SessionScoped;
import Service.SiteService;
import Service.SiteServiceLocal;
import entities.Pays;

@ManagedBean
@ViewScoped

public class PaysBean {
	@EJB
	SiteServiceLocal ssl;
	@EJB
	SiteService ss;
	private String nom;
	private Pays pays;
	private List<Pays> lesPays;
	private Pays selected;
	private boolean selection=false;
	
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
		lesPays=ssl.getAllPays();
		return lesPays;
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
	public Pays getPaysById(int id) {
		return ssl.getPaysByID(id);
	}
	public String updatePays () {
		this.selected.setNom(this.nom);
		ssl.updatePays(this.selected);
		return "updated";
	}
	
	public String selectPays (Pays p) {
		this.selected=p;
	    this.nom=p.getNom();
		System.out.println(p.getNom());
		this.selection=true;
		return p.getNom().concat(" si selected.");
	}

	public Pays getSelected() {
		return selected;
	}

	public void setSelected(Pays selected) {
		this.selected = selected;
	}

	public boolean isSelection() {
		return selection;
	}

	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	public String unSelectPays() {
		this.selected=new Pays();
	    this.nom="";
		this.selection=false;
		return "unselection";
	}
	
}
