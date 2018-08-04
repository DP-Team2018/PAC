package fediBean;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Service.MissionServiceLocal;
import entities.Agent;
import entities.Flux;
import entities.Mission;

@SessionScoped
@ManagedBean
public class MissionBean {

	private int id;
	private String etat;
	private Date date_mission;
	private Flux flux;
	private Agent agent;
	private Mission mission;
	
	@EJB
	MissionServiceLocal ms;
	
	public MissionBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void addMissionBean()
	{
		ms.addMission(mission);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDate_mission() {
		return date_mission;
	}
	public void setDate_mission(Date date_mission) {
		this.date_mission = date_mission;
	}
	public Flux getFlux() {
		return flux;
	}
	public void setFlux(Flux flux) {
		this.flux = flux;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	
}
