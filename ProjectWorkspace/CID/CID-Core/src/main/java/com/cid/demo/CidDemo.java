package com.cid.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cid.config.AppConfigCid;
import com.cid.dao.UserDao;
import com.cid.model.User;
import com.cid.utils.CidMocks;

public class CidDemo {

	public static void main(String[] args) {

		userDaoImplByName("userDaoHibernateBMT");	
		//userDaoImplByName("userDaoHibernateCMT");	
	}

	private static void userDaoImplByName(String daoBeanImpl) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigCid.class);
		UserDao userDao = context.getBean(daoBeanImpl,UserDao.class);
		
		Long createdId = userDao.createUser(CidMocks.mockUser());
		System.out.println("Id of the created user "+createdId);
		
		User user = userDao.findById(createdId);
		System.out.println("Found user: "+user.toString());
		
		user.setId(createdId);
		userDao.updateUser(user);	
		System.out.println("Updated!");
		
		userDao.deleteUser(user);
		System.out.println("Deleted!");
		
		List<User> users = userDao.findByTeamId(2L);
		System.out.println("Found users by teamId: "+users.toString());		
		
		List<User> allUsers = userDao.loadAllUsers();
		System.out.println("All users are: "+allUsers.toString());	
		
		/*
		User user = userDao.findById(77L);		
		System.out.println("Found " + user.toString());
		
		List<User> users = userDao.findByTeamId(4L);
		System.out.println("Found "+users.toString());		
		
		userDao.updateUser(CidMocks.mockUser3());		 
		
		userDao.deleteUser(CidMocks.mockUser2());
	
		List<User> allUsers = userDao.loadAllUsers();
		System.out.println("Users are "+allUsers.toString());	
		
		List<User> usersWithSales = userDao.findUsersWithSales();
		System.out.println("Users with sales "+usersWithSales.toString());
		*/
		 
	}

}
