package com.cid.dao;

import static com.cid.dao.Queries.GET_USER_BY_ID;
import static com.cid.dao.Queries.GET_USER_BY_TEAM_ID;
import static com.cid.dao.Queries.CREATE_USER;
import static com.cid.dao.Queries.GET_ALL_USERS;
import static com.cid.dao.Queries.DELETE_USER_BY_ID;
import static com.cid.dao.Queries.UPDATE_USER_BY_ID;
import static com.cid.dao.Queries.GET_USERS_WITH_SALES;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cid.beans.UserDto;
import com.cid.dao.helpers.UserRowMapper;
import com.cid.dao.helpers.UserRsExtractor;
import com.cid.model.User;

@Repository
public class UserDaoJdbcTemplate implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRowMapper userRowMapper;	
	
	@Autowired
	private UserRsExtractor userRsExtractor; 
	
	@Override
	public User findById(Long id) {
		return jdbcTemplate.queryForObject(GET_USER_BY_ID,new Object[] { id }, userRowMapper);			
	}

	@Override
	public List<User> findByTeamId(Long teamId) {		
		return jdbcTemplate.query(GET_USER_BY_TEAM_ID,new Object[] { teamId }, userRowMapper);	
	}

	@Override
	public void createUser(UserDto newUser) {
		jdbcTemplate.update(CREATE_USER, newUser.getDepartmentId(), newUser.getTeamId(), newUser.getRoleId(), newUser.getFirstname(), newUser.getLastname(), newUser.getUsername(), newUser.getPassword());	
	}

	@Override
	public List<User> loadAllUsers() {
		return jdbcTemplate.query(GET_ALL_USERS, userRowMapper);		
	}

	@Override
	public void deleteUser(Long id) {
		jdbcTemplate.update(DELETE_USER_BY_ID, id);	
	}
	
	@Override
	public void updateUser(Long id, UserDto userToUpdate) {
		jdbcTemplate.update(UPDATE_USER_BY_ID, userToUpdate.getDepartmentId(), userToUpdate.getTeamId(), userToUpdate.getRoleId(), userToUpdate.getFirstname(), userToUpdate.getLastname(), userToUpdate.getUsername(), userToUpdate.getPassword(), id);	
	}
	
	@Override
	public List<User> findUsersWithSales() {
	   Map<Long, User> resultsetAsMap = jdbcTemplate.query(GET_USERS_WITH_SALES, userRsExtractor);
	   return new ArrayList<User>(resultsetAsMap.values());
	}

}

	


