package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;



/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

    /**
     * Default constructor. 
     */
    public UserService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    
	public void addUser(User user) {
		
			em.persist(user);	
	}
	List<User> users;
	
	

	@Override
	public void UpdateUser(User user) {

		em.merge(user);
	}

	@Override
	public void DeleteUser(User user) {
		em.remove(user);
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String FirstName) {
		// TODO Auto-generated method stub
		return null;
	}
}
