package fediBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import Service.MissionServiceLocal;
import entities.Affectation;
import entities.Agent;
import entities.Flux;
import entities.Mission;

@ManagedBean
@SessionScoped
public class MissionBean {

	private int id;
	private String etat;
	private Date date_mission;
	private Flux flux;
	private Agent agent;
	private Mission mission;
	
	private Date debut;
	private Date fin;
	private Date selectedDate;
	
	private Affectation affect;
	private List<Date> rangeDates;
	
	private String test="test";

	@ManagedProperty(value="#{scheduleView}")
	private ScheduleView sv;
	

	@EJB
	private MissionServiceLocal ms;
	
	
	@PostConstruct
	public void init() {
		System.out.println("test test test");
		affect=sv.getAffectToPass();
		System.out.println("flux apres :   "+affect.getFlux().getIntitule());
		/*rangeDates=getDatesBetween(affect.getDate_debut(), affect.getDate_fin());
		for (Date date : rangeDates) {
			System.out.println(date.toString());
		}*/
	}
	
	public MissionBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void addMissionBean()
	{
		ms.addMission(mission);
	}
	
	public static List<Date> getDatesBetween(
			  Date startDate, Date endDate) {
			    List<Date> datesInRange = new ArrayList<>();
			    Calendar calendar = new GregorianCalendar();
			    calendar.setTime(startDate);
			     
			    Calendar endCalendar = new GregorianCalendar();
			    endCalendar.setTime(endDate);
			 
			    while (calendar.before(endCalendar)) {
			        Date result = calendar.getTime();
			        datesInRange.add(result);
			        calendar.add(Calendar.DATE, 1);
			    }
			    return datesInRange;
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

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public List<Date> getRangeDates() {
		return rangeDates;
	}

	public void setRangeDates(List<Date> rangeDates) {
		this.rangeDates = rangeDates;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public Affectation getAffect() {
		return affect;
	}

	public void setAffect(Affectation affect) {
		this.affect = affect;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public ScheduleView getSv() {
		return sv;
	}

	public void setSv(ScheduleView sv) {
		this.sv = sv;
	}

	public MissionServiceLocal getMs() {
		return ms;
	}

	public void setMs(MissionServiceLocal ms) {
		this.ms = ms;
	}

	
}
