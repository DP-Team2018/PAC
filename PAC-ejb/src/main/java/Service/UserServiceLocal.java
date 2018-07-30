package Service;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServiceLocal {
	public void addUser(User user);
	public User authenticate(String email, String password) ;
	List<User> listUsers();
	boolean loginExists(String email);
	public void saveOrUpdate(User user);
	public User getConnected();
	public void setConnected(User connected);




}
