package Service;

import java.util.List;

import javax.ejb.Local;


import entities.User;

@Local
public interface UserServiceLocal {
	public void addUser(User user);
	public void UpdateUser(User user);
	public void DeleteUser(User user);
	public List<User> listUser();
	User findUserByUsername(String FirstName);
	


}
