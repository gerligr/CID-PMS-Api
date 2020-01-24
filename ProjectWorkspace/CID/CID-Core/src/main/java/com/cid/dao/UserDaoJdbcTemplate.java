package com.cid.dao;

import static com.cid.dao.Queries.GET_USER_BY_ID;
import static com.cid.dao.Queries.GET_USER_BY_TEAM_ID;
import static com.cid.dao.Queries.CREATE_USER;
import static com.cid.dao.Queries.GET_ALL_USERS;
import static com.cid.dao.Queries.DELETE_USER_BY_ID;
import static com.cid.dao.Queries.UPDATE_USER_BY_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cid.beans.UserDto;
import com.cid.dao.helpers.UserRowMapper;
import com.cid.model.User;

@Repository
public class UserDaoJdbcTemplate implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRowMapper userRowMapper;	
	
	@Override
	public User findById(int id) {
		return jdbcTemplate.queryForObject(GET_USER_BY_ID,new Object[] { id }, userRowMapper);			
	}

	@Override
	public List<User> findByTeamId(int teamId) {		
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
	public void deleteUser(int id) {
		jdbcTemplate.update(DELETE_USER_BY_ID, id);	
	}
	
	@Override
	public void updateUser(int id, UserDto userToUpdate) {
		jdbcTemplate.update(UPDATE_USER_BY_ID, userToUpdate.getDepartmentId(), userToUpdate.getTeamId(), userToUpdate.getRoleId(), userToUpdate.getFirstname(), userToUpdate.getLastname(), userToUpdate.getUsername(), userToUpdate.getPassword(), id);	
	}

}

	


