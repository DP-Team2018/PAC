package fediBean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import Service.AffectationServiceLocal;
import Service.FluxServiceLocal;
import entities.Affectation;
import entities.Flux;

@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {

	private ScheduleModel eventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();
	
	private ScheduleEvent eventformap;

	private Flux flux;
	
	private int idFlux;
	
	private List<Flux> listFlux;
	
	private Map<String,Affectation> map;

	@EJB
	private AffectationServiceLocal as;
	
	@EJB
	private FluxServiceLocal fs;

	private List<Affectation> ListAffectation;

	@PostConstruct
	public void init() {
		listFlux=fs.findListFlux();
		eventModel = new DefaultScheduleModel();
		map=new HashMap<String,Affectation>();
		ListAffectation = as.findListAffectation();
		for (Affectation affectation : ListAffectation) {
			eventformap=new DefaultScheduleEvent(affectation.getFlux().getIntitule(), affectation.getDate_debut(), affectation.getDate_fin());
			eventModel.addEvent(eventformap);
			map.put(eventformap.getId(), affectation);
			//eventModel.addEvent(new DefaultScheduleEvent("test", affectation.getDate_debut(), affectation.getDate_fin()));
		}
		// eventModel.addEvent(new DefaultScheduleEvent("Champions League
		// Match", previousDay8Pm(), previousDay11Pm()));

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


	private Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}

	private Date previousDay8Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
		t.set(Calendar.HOUR, 8);

		return t.getTime();
	}

	private Date previousDay11Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
		t.set(Calendar.HOUR, 11);

		return t.getTime();
	}

	private Date today1Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 1);

		return t.getTime();
	}

	private Date theDayAfter3Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);

		return t.getTime();
	}

	private Date today6Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 6);

		return t.getTime();
	}

	private Date nextDay9Am() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.AM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
		t.set(Calendar.HOUR, 9);

		return t.getTime();
	}

	private Date nextDay11Am() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.AM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
		t.set(Calendar.HOUR, 11);

		return t.getTime();
	}

	private Date fourDaysLater3pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
		t.set(Calendar.HOUR, 3);

		return t.getTime();
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
		flux=findFluxById(idFlux);
		Affectation affect;
		ScheduleEvent event2;
		event2=new DefaultScheduleEvent(flux.getIntitule(),event.getStartDate(),event.getEndDate());
		event2.setId(event.getId());
		if (event.getId() == null) {
			eventModel.addEvent(event2);
			affect = new Affectation(event.getStartDate(), event.getEndDate(),flux);
			as.addAffectation(affect);
			map.put(event.getId(), affect);
		}

		else {
			int id=map.get(event.getId()).getId();
			System.out.println("id :    " + id);
			affect=new Affectation(id, event2.getStartDate(), event2.getEndDate(), flux);
			eventModel.updateEvent(event2);
			as.updateAffectation(affect);
			map.put(event.getId(), affect);
		}

		event = new DefaultScheduleEvent();
	}
	
	public void deleteEvent(ActionEvent actionEvent){
		eventModel.deleteEvent(event);
		Affectation affect=new Affectation();
		affect=map.get(event.getId());
		as.deleteAffectation(affect);
		map.remove(event.getId());
		
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		System.out.println(map.containsKey(event.getId()));
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
	
	public Flux findFluxById(int id){
		for (Flux f :listFlux){
			if (f.getId() == id)
				return f;
		}
		return null;
	}
}