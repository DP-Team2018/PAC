package ammarBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;

import Service.StaffServiceLocal;
import entities.Staff;

@ManagedBean
@ApplicationScoped

public class StaffBean implements Serializable{
	
					private int idStaff;
					private String nom;
					private String prenom;
					private String matricule;
					private String typeContrat;
					private int nbreHeure;
				
					
					
					private static final long serialVersionUID = 1L;
				
					private List<Staff> staffs;
				    
				    private List<Staff> filteredStaff;
				     
				    private Staff selectedStaff;
				    
				    @EJB
					private StaffServiceLocal staffService;
					private boolean formDisplay = false;
					private List<Staff> list = new ArrayList<Staff>();
    
					private Staff staff = new Staff();

					public boolean isFormDisplay() {
						return formDisplay;
					}


					public List<Staff> displayStaff(){
						return list = staffService.findAll();
					}
					
					
					public void buttonAction(ActionEvent actionEvent) {
				        addMessage("effectué avec succés!!");
				    }
					public void addMessage(String summary) {
				        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
				        FacesContext.getCurrentInstance().addMessage(null, message);
				    }

					public void setFormDisplay(boolean formDisplay) {
						this.formDisplay = formDisplay;
					}
					
					
	
	
					public StaffBean() {
						super();
					}

					
					public String Save(){
						staffService.AddStaff(staff);
						return "staff?faces-redirect=true";
					}
					
					public String delete(Staff staff){
						staffService.DeleteStaff(staff);
						return null;
					}

					public void reset() {
				        PrimeFaces.current().resetInputs("form2:panel2");
				    }


					public int getIdStaff() {
						return idStaff;
					}




					public void setIdStaff(int idStaff) {
						this.idStaff = idStaff;
					}




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




					public String getTypeContrat() {
						return typeContrat;
					}




					public void setTypeContrat(String typeContrat) {
						this.typeContrat = typeContrat;
					}




					public int getNbreHeure() {
						return nbreHeure;
					}




					public void setNbreHeure(int nbreHeure) {
						this.nbreHeure = nbreHeure;
					}




					public List<Staff> getStaffs() {
						return staffs;
					}




					public void setStaffs(List<Staff> staffs) {
						this.staffs = staffs;
					}




					public List<Staff> getFilteredStaff() {
						return filteredStaff;
					}




					public void setFilteredStaff(List<Staff> filteredStaff) {
						this.filteredStaff = filteredStaff;
					}




					public Staff getSelectedStaff() {
						return selectedStaff;
					}




					public void setSelectedStaff(Staff selectedStaff) {
						this.selectedStaff = selectedStaff;
					}




					public StaffServiceLocal getStaffService() {
						return staffService;
					}




					public void setStaffService(StaffServiceLocal staffService) {
						this.staffService = staffService;
					}




					public List<Staff> getList() {
						return list;
					}




					public void setList(List<Staff> list) {
						this.list = list;
					}




					public Staff getStaff() {
						return staff;
					}




					public void setStaff(Staff staff) {
						this.staff = staff;
					}
					
					
}
