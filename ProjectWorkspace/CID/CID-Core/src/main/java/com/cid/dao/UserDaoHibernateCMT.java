package com.cid.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cid.model.User;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoHibernateCMT implements UserDao{

	@PersistenceContext
    private Session session;
	
	@Override	
	public User findById(Long id) {			
		return session.get(User.class, id);		
	}

	@Override	
	public List<User> findByTeamId(Long teamId) {
		Query<User> query =session.createNamedQuery("User_ByTeamId", User.class);
		query.setParameter("teamId", teamId);
		return query.getResultList();
	}

	@Override
	public Long createUser(User newUser) {		
		return (Long)session.save(newUser);			
	}

	@Override
	public void updateUser(User updatedUser) {
		session.update(updatedUser);			
	}

	@Override	
	public void deleteUser(User updatedUser) {
		session.delete(updatedUser);		
	}

	@Override
	public List<User> loadAllUsers() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public List<User> findUsersWithSales() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
