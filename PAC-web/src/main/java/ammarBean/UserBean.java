package ammarBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Service.UserServiceLocal;
import entities.User;

@ManagedBean
@ApplicationScoped

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@EJB
	private UserServiceLocal userService;
	
	private User user = new User();
	private Boolean isLogged = false;
	
	private static User stUser;
	private static User conUser;
	public static int i = 0;
	private List<User> listUsers;
   
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUsers() {
		
			return listUsers;
		
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public UserBean() {
		super();
	}

	public void CreateUser() {
		
		setConUser(user);
		user.setRole("user");
		userService.addUser(user);
	}
	
	@PostConstruct
	public void init() {
		listUsers = userService.listUsers();
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







	
	
	

	
}
