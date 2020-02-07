package com.cid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cid.beans.UserDto;
import com.cid.beans.UserSearchDto;
import com.cid.dao.DepartmentDao;
import com.cid.dao.TeamDao;
import com.cid.dao.UserDao;
//import com.cid.dao.teamDao;
import com.cid.dao.filters.UserFilter;
import com.cid.exceptions.UserException;
import com.cid.model.Department;
import com.cid.model.User;
import com.cid.utils.BeanMappingUtils;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private DepartmentDao departmentDao;
	
	//@Autowired
	//private TeamDao teamDao;
	
	public Long saveUser(UserDto userDto) {			
		
		 Department department = departmentDao.findById(userDto.getDepartment().getDepartmentId()).orElseThrow();
		 		 
		 User user = BeanMappingUtils.dto2Model(userDto);	
		 user.setDepartment(department);
		 
		 
		 
		 //Team team = teamDao.findById(userDto.getTeam().getTeamId());
		
		 
		 	 
		 
		 //user.setTeam(team);
		 
		 User savedUser = userDao.save(user);
		 return savedUser.getId();
	}

	public UserDto findById(Long id) {				
		if (!(userDao.findById(id).isPresent())){
			throw new UserException("User was not found!");
		} else {
			User user = userDao.findById(id).get();
			UserDto userDto = BeanMappingUtils.model2Dto(user);
			return userDto;
		}
	}	
	
	public List<User> searchUsers(UserSearchDto filters){
		return userDao.findAll(new UserFilter(filters));				
	}
	
	public List<User> viewAllCourses(){
		return userDao.findAll();		
	}
	
	public List<User> findByTeamId(Long teamId){
		return userDao.findByTeamId(teamId);
	}

}
