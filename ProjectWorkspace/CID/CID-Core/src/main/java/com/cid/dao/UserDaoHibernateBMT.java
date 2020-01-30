package com.cid.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cid.beans.UserDto;
import com.cid.model.User;

@Repository
public class UserDaoHibernateBMT implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		User user = session.get(User.class, id);
		session.getTransaction().commit();
		return user;					
	}

	@Override
	public List<User> findByTeamId(Long teamId) {		
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Query<User> query = session.createNamedQuery("User_ByTeamId", User.class);
		query.setParameter("teamId", teamId);
		List<User> users = query.getResultList();
		session.getTransaction().commit();
		return users;		
	}

	@Override
	public Long createUser(User newUser) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Long generatedUser= (Long)session.save(newUser);	
		session.getTransaction().commit();
		return generatedUser;			
	}	

	@Override
	public void deleteUser(User updatedUser) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.delete(updatedUser);	
		session.getTransaction().commit();
	}
	
	@Override
	public void updateUser(User updatedUser) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.update(updatedUser);
		session.getTransaction().commit();
	}

	@Override
	public List<User> loadAllUsers() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public List<User> findUsersWithSales() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	
	/*
	 * @Override public List<User> findUsersWithSales() { Map<Long, User>
	 * resultsetAsMap = jdbcTemplate.query(GET_USERS_WITH_SALES, userRsExtractor);
	 * return new ArrayList<User>(resultsetAsMap.values()); }
	 * 
	 * @Override public List<User> loadAllUsers() { return
	 * jdbcTemplate.query(GET_ALL_USERS, userRowMapper); }
	 */
	 

}

	


