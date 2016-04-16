package es.isst.glucomed.dao;

import javax.persistence.EntityManager;

import es.isst.glucomed.model.User;

public class UserDAOImpl implements UserDAO{
	
	private static UserDAOImpl instance;
	
	private UserDAOImpl(){}
	
	public static  UserDAOImpl getInstance(){
		if(instance==null)
			instance = new UserDAOImpl();
		return instance;
	}
	
	public boolean createUser(String nombre, String apellidos, String password, String email) { 
				
		User u = new User (nombre, apellidos, password, email);
		
		boolean testUser = SuccessLogin (email,password);
		//boolean testUser = false;
		
		if (!testUser) { 
			EntityManager em = EMFService.get().createEntityManager();
			em.persist(u);
			em.close(); 
			return true;
		} else {
			return false;
		}

	} 
	
	
	public boolean SuccessLogin (String email, String password){
		
		EntityManager em = EMFService.get().createEntityManager();
		
		User user = em.find(User.class, email);
		
		em.close();
		
		if (user == null) {
			return false;
		} else {
			return true;
		}
		
		/*
		Query q = em.createQuery("select item from User item where item.email = :email and item.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		
		if(q.getResultList().isEmpty()){
			return false;
		} else {
			return true;	
		}
		
		*/
		
	}
	
	
}
