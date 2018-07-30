<<<<<<< HEAD
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
=======
package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServiceRemote {
	public void addUser(User user);
	public void UpdateUser(User user);
	public void DeleteUser(User user);
	public List<User> listUser();
	User findUserByUsername(String FirstName);
}
>>>>>>> branch 'master' of https://github.com/DP-Team2018/PAC.git
