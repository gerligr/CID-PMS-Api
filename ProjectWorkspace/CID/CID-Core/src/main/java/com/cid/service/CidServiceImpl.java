package com.cid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cid.beans.UserDto;
import com.cid.dao.UserDao;

import lombok.Data;

@Data
@Service
public class CidServiceImpl implements CidService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void feature(UserDto user) {		
		userDao.createUser(user);
		userDao.loadAllUsers();		
	}
	
	@Override
	public void findUser(int id) {
		userDao.findById(id);		
	}
	
	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	
	@Override
	public void updateUser(int id, UserDto user) {
		userDao.updateUser(id, user);
	}
	
	
	/*public static void main(String[] args) {
	
	UserDao userDao = new UserDao();	
	
	UserModel newUser = new UserModel();
	newUser.setDepartmentId(2);
	newUser.setTeamId(3);
	newUser.setRoleId(3);
	newUser.setFirstname("Siiri");
	newUser.setLastname("Muhu");
	newUser.setUsername("siiri.muhu@cid.com");
	newUser.setPassword("muhu1234");	
			
	userDao.createUser(newUser);
	
	userDao.loadAllUsers();
	
	UserModel foundUser = userDao.findById(7);		
	System.out.println("UserModel values: "+foundUser.toString());	
	
	ArrayList<UserModel> usersList = userDao.findByTeamId(4);
	System.out.println("UserList values: "+usersList.toString());	
	
	userDao.deleteUser(28);		
	
	UserModel userToUpdate = new UserModel();
	newUser.setDepartmentId(2);
	newUser.setTeamId(3);
	newUser.setRoleId(3);
	newUser.setFirstname("Reet");
	newUser.setLastname("Muhu");
	newUser.setUsername("siiri.muhu@cid.com");
	newUser.setPassword("muhu1234");	
	
	userDao.updateUser(37, userToUpdate);
	
	
}*/
	

}
