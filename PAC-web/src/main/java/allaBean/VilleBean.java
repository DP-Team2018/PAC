package allaBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Service.SiteService;
import Service.SiteServiceLocal;
import entities.Pays;
import entities.Ville;

@ManagedBean
@ViewScoped
public class VilleBean {
	@EJB
	SiteServiceLocal ssl;
	@EJB
	SiteService ss;
	private String nom;
	private Pays pays;
	private int paysId;
	private Ville ville;
	private Ville selected;
	private boolean selection;

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
	
	public List<Ville> getAllVillesByPays(Pays p){
		return ssl.getVillesByPays(p);
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
	public Ville getSelected() {
		return selected;
	}

	public void setSelected(Ville selected) {
		this.selected = selected;
	}

	public boolean isSelection() {
		return selection;
	}

	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	public String selectVille (Ville v) {
		this.selected=v;
	    this.nom=v.getNom();
	    this.pays=v.getPays();
		System.out.println(v.getNom());
		this.selection=true;
		return v.getNom().concat(" si selected.");
	}
	public String unSelectVille() {
		this.selected=new Ville();
	    this.nom="";
	    this.pays=new Pays();
	    this.paysId=0;
		this.selection=false;
		return "unselection";
	}
	public String updateVille () {
		pays=ssl.getPaysByID(paysId);
		this.selected.setNom(this.nom);
		this.selected.setPays(this.pays);
		ssl.updateVille(this.selected);
		return "updated";
	}
}
