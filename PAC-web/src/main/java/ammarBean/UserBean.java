package ammarBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Service.UserServiceLocal;
import entities.User;

@ManagedBean
@ApplicationScoped

public class UserBean implements Serializable {
	private int idUser;
	private String nom;
	private String prenom;
	private String role;
	private String password;
	private String email;
	private Date dob;
	private String sexe;
	private String remark;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
   
    
    
	@EJB
	private UserServiceLocal userService;
	private boolean formDisplay = false;
	private List<User> list = new ArrayList<User>();


	private User user = new User();
	private Boolean isLogged = false;
	
	//private static User stUser;
	private static User conUser;
	public static int i = 0;
	
	
	
	public List<User> displayUser(){
		return list = userService.findAll();
	}

	
	
	public boolean isFormDisplay() {
		return formDisplay;
	}




	public void setFormDisplay(boolean formDisplay) {
		this.formDisplay = formDisplay;
	}




	public List<User> getList() {
		return list;
	}




	public void setList(List<User> list) {
		this.list = list;
	}





	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public UserBean() {
		super();
	}

	public String Save(){
		userService.AddUser(user);
		return "users?faces-redirect=true";
	}
	
	public String delete(User user){
		userService.DeleteUser(user);
		return null;
	}
	
	
	
	
	

	public String doLogin() {
		 
		String navTo = "";
		User found = userService.authenticate(user.getEmail(), user.getPassword());
		if (i < 3) {

			if (found != null) {
				setConUser(found);
				user = found;
				
				setIsLogged(true);
				
				// redirect to admin
				if (user.getRole().equals("Admin")) {
					navTo = "/PagesAdmin/index?faces-redirect=true";
					// redirect to profile user
				}
				if (!user.getRole().equals("Admin")) {
					navTo = "/Pages/index?faces-redirect=true";
				}

			} else {
				i++;
				FacesContext.getCurrentInstance().addMessage("login_form:login_submit",
						new FacesMessage("Wrong Username or Password"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("login_form:login_submit",
					new FacesMessage("3 times wrong informations, access blocked for security reasons"));
		}

		return navTo;
	}
	
	
	
	
	
	
	public static User getConUser() {
		return conUser;
	}

	public static void setConUser(User conUser) {
		UserBean.conUser = conUser;
	}
	public  User getConUser1() {
		return conUser;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}
//
	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}







	
	
	

	
}
