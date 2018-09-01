package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServiceRemote {
	public boolean AddUser(User user);
	public User authenticate(String email, String password) ;
	public List<User> findAll();
	boolean loginExists(String email);
	public void saveOrUpdate(User user);
	public User getConnected();
	public void setConnected(User connected);
	void DeleteUser(User user);
}