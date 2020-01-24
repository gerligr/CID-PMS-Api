package com.cid.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cid.config.AppConfigCid;
import com.cid.dao.UserDao;
import com.cid.model.User;
import com.cid.utils.CidMocks;

public class UserService {

	public static void main(String[] args) {

		// userDaoImplByName("userDaoJdbcSupportImpl");
		//userDaoImplByName("userDaoJdbcTemplate");
		userDaoImplByName("userDaoNamedParametersJdbcTemplate");
	}

	private static void userDaoImplByName(String daoBeanImpl) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigCid.class);

		UserDao userDao = context.getBean(daoBeanImpl, UserDao.class);

		
		User user= userDao.findById(60);
		System.out.println("Found "+user.toString());
	  
		List<User> users = userDao.findByTeamId(2);
		System.out.println("Found "+users.toString());
		 
		 
		userDao.createUser(CidMocks.mockUser());
		
		
		 List<User> allUsers = userDao.loadAllUsers();
		 System.out.println("Users are "+allUsers.toString());
		  
		 userDao.deleteUser(4);
		  
		 userDao.updateUser(6, CidMocks.mockUser2());
		 
	}

}
