package Service;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServiceLocal {
	public boolean AddUser(User user);
	public User authenticate(String email, String password) ;
	public List<User> findAll();
	boolean loginExists(String email);
	public void saveOrUpdate(User user);
	public User getConnected();
	public void setConnected(User connected);
	void DeleteUser(User user);



}
