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
