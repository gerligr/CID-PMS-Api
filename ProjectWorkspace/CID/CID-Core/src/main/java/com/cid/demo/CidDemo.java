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

		userDaoImplByName();		
	}

	private static void userDaoImplByName() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigCid.class);

		UserDao userDao = context.getBean(UserDao.class);

		
		//User user= userDao.findById(60L);
		//System.out.println("Found "+user.toString());
	  
		//List<User> users = userDao.findByTeamId(2L);
		//System.out.println("Found "+users.toString());
		 
		 
	//	userDao.createUser(CidMocks.mockUser());		
	//	
	//	List<User> allUsers = userDao.loadAllUsers();
	//	System.out.println("Users are "+allUsers.toString());
		  
	//	userDao.deleteUser(4L);
		  
	//	userDao.updateUser(6L, CidMocks.mockUser2());
		
		List<User> usersWithSales = userDao.findUsersWithSales();
		System.out.println("Users with sales "+usersWithSales.toString());
		
		 
	}

}
