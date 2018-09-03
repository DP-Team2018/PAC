package fediBean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import Service.AffectationServiceLocal;
import Service.FluxServiceLocal;
import Service.MissionServiceLocal;
import entities.Affectation;
import entities.Flux;
import entities.Mission;

@ManagedBean(name = "scheduleView")
@SessionScoped
public class ScheduleView {

	private ScheduleModel eventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();

	private ScheduleEvent eventformap;

	private Flux flux;

	private int idFlux;

	private Affectation affectToPass;

	private List<Flux> listFlux;

	private List<Date> rangeDates;

	private Date selectedDate;

	private String dateString;

	private Mission selectedMission;

	private List<Mission> listMission;

	private Map<String, Affectation> map;

	@EJB
	private AffectationServiceLocal as;

	@EJB
	private MissionServiceLocal ms;

	@EJB
	private FluxServiceLocal fs;

	private List<Affectation> ListAffectation;

	private final String test = "test";

	@PostConstruct
	public void init() {
		listFlux = fs.findListFlux();
		eventModel = new DefaultScheduleModel();
		map = new HashMap<String, Affectation>();
		ListAffectation = as.findListAffectation();
		
		for (Affectation affectation : ListAffectation) {
			eventformap = new DefaultScheduleEvent(affectation.getFlux().getIntitule(), affectation.getDate_debut(), affectation.getDate_fin(), "background: red;");
			eventModel.addEvent(eventformap);
			map.put(eventformap.getId(), affectation);
		}
	}

	public Date getRandomDate(Date base) {
		Calendar date = Calendar.getInstance();
		date.setTime(base);
		date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1); // set random
																	// day of
																	// month

		return date.getTime();
	}

	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar.getTime();
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	/*
	 * private Calendar today() { Calendar calendar = Calendar.getInstance();
	 * calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
	 * calendar.get(Calendar.DATE), 0, 0, 0);
	 * 
	 * return calendar; }
	 */

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
		flux = findFluxById(idFlux);
		Affectation affect;
		Mission mission;
		ScheduleEvent event2;
		event2 = new DefaultScheduleEvent(flux.getIntitule(), event.getStartDate(), event.getEndDate(),"background: red;");
		event2.setId(event.getId());
		if (event.getId() == null) {
			eventModel.addEvent(event2);
			affect = new Affectation(event.getStartDate(), event.getEndDate(), flux);
			as.addAffectation(affect);
			map.put(event.getId(), affect);
		}

		else {
			int id = map.get(event.getId()).getId();
			System.out.println("id :    " + id);
			affect = new Affectation(id, event2.getStartDate(), event2.getEndDate(), flux);
			eventModel.updateEvent(event2);
			as.updateAffectation(affect);
			map.put(event.getId(), affect);
		}

		rangeDates = getDatesBetween(affect.getDate_debut(), affect.getDate_fin());
		for (Date date : rangeDates) {
			mission = new Mission("null", date, affect, null);
			ms.addMission(mission);
		}

		event = new DefaultScheduleEvent();
	}

	public void deleteEvent(ActionEvent actionEvent) {
		eventModel.deleteEvent(event);
		Affectation affect = new Affectation();
		affect = map.get(event.getId());
		as.deleteAffectation(affect);
		map.remove(event.getId());

	}

	public void selectFlux() {
		affectToPass = map.get(event.getId());
		rangeDates = getDatesBetween(affectToPass.getDate_debut(), affectToPass.getDate_fin());
	}

	public static List<Date> getDatesBetween(Date startDate, Date endDate) {
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

	public void selectSpecificMission() throws ParseException {
		System.out.println("date chosen !!!!!");
		 System.out.println(" affect "+affectToPass.getId());
		// System.out.println("date string "+dateString);
		selectedDate = StringDateConverter(dateString);
		 System.out.println("date selected "+selectedDate.toString());
		listMission = new ArrayList<Mission>();
		listMission = ms.findMissionbyDateAffect(selectedDate, affectToPass);
		for (Mission m : listMission) {
			System.out.println("mission :  " + m.getAffectation().getId());
		}
	}

	public void deleteSelectedMission() {
		System.out.println("removed mission : " + selectedMission.getId());
		ms.removeMission(selectedMission);
		listMission.remove(selectedMission);
	}

	/*
	 * Getters and Setters below , plus schedule functions !! !!
	 */
	public Date StringDateConverter(String d) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
		Date date = (Date) formatter.parse(d);
		return date;
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<Affectation> getListAffectation() {
		return ListAffectation;
	}

	public void setListAffectation(List<Affectation> listAffectation) {
		ListAffectation = listAffectation;
	}

	public Flux getFlux() {
		return flux;
	}

	public void setFlux(Flux flux) {
		this.flux = flux;
	}

	public int getIdFlux() {
		return idFlux;
	}

	public void setIdFlux(int idFlux) {
		this.idFlux = idFlux;
	}

	public List<Flux> getListFlux() {
		return listFlux;
	}

	public void setListFlux(List<Flux> listFlux) {
		this.listFlux = listFlux;
	}

	public Flux findFluxById(int id) {
		for (Flux f : listFlux) {
			if (f.getId() == id)
				return f;
		}
		return null;
	}

	public Affectation getAffectToPass() {
		return affectToPass;
	}

	public void setAffectToPass(Affectation affectToPass) {
		this.affectToPass = affectToPass;
	}

	public String getTest() {
		return test;
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

	public List<Mission> getListMission() {
		return listMission;
	}

	public void setListMission(List<Mission> listMission) {
		this.listMission = listMission;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public Mission getSelectedMission() {
		return selectedMission;
	}

	public void setSelectedMission(Mission selectedMission) {
		this.selectedMission = selectedMission;
	}

}