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
import javax.net.ssl.SSLParameters;

import java.util.List;
import Service.AgentService;
import Service.AgentServiceLocal;
import Service.SiteService;
import Service.SiteServiceLocal;
import entities.Agent;
import entities.Site;

@ManagedBean
@RequestScoped
public class AgentBean {
	@EJB
	private AgentServiceLocal asl;
	@EJB
	private AgentService as;
	@EJB
	SiteServiceLocal ssl;
	@EJB
	SiteService ss;
	private String nom;
	private String prenom;
	private String matricule;
	private Agent agent;
	private List<Agent> agents;
	private int siteId;
	private Site site;
	private List<Site> sites;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	public String addAgent() {
		site = new Site();
		site = ssl.getSiteByID(siteId);
		agent=new Agent(nom,prenom,matricule,site);
		asl.addAgent(agent);
		System.out.println(agent.getNom().concat(" ").concat(agent.getPrenom()));
		return "valider".concat(agent.getNom());
	}
	public List<Agent> getAllAgents() {
		return asl.getAllAgent();
	}
	
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
	
	public List<Site> getAllSites(){
		return ssl.getAllSites();
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	
}
