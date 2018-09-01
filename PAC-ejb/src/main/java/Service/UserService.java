package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.User;



/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

	private List <User> lst=new ArrayList<User>();

	@PersistenceContext
	private EntityManager em;
	
		public UserService(){
				
			}
	
	List<User> usersRole;
	private User connected=new User();
	
	

	
	public User authenticate(String email, String password) {
		User found = null;
		String jpql = "select u from User u where u.email=:email and u.password=:password";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			found = query.getSingleResult();
			setConnected(found);
			                                                     
		} catch (Exception ex) {
			Logger.getLogger(UserService.class.getName()).log(
					Level.WARNING,
					"authentication attempt failure with login=" + email
							+ " and password=" + password);
		}
		return found;
	}
	
	
	
	@Override
	public boolean loginExists(String email) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from User u where u.email=:email";
		TypedQuery<Boolean> query = em.createQuery(jpql, Boolean.class);
		query.setParameter("email", email);
		try {
			exists = query.getSingleResult();
		} catch (NoResultException e) {
			Logger.getLogger(UserService.class.getName()).log(
					Level.WARNING, "no user registred with login=" + email);
		}
		return exists;
	}

	@Override
	public void saveOrUpdate(User user) {
		em.merge(user);	
	}

	public User getConnected() {
		return connected;
	}

	public void setConnected(User connected) {
		this.connected = connected;
	}

	@Override
	public void DeleteUser(User user) {
		em.remove(em.merge(user));

		
	}

	
	
	@Override
	public List<User> findAll() {
		return em.createQuery("select t from User t",User.class ).getResultList();
	}

	@Override
	public boolean AddUser(User user) {
		em.persist(user);
		return true;
	}

	
	
	



	

	

  
}
