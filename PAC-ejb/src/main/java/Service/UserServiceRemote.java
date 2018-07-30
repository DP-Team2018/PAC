package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServiceRemote {
	public void addUser(User user);
	public User authenticate(String email, String password) ;
	List<User> listUsers();
	boolean loginExists(String email);
	public void saveOrUpdate(User user);
	public User getConnected();
	public void setConnected(User connected);

}
