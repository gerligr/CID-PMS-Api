package com.cid.dao;

import static com.cid.dao.Queries.GET_USER_BY_ID;
import static com.cid.dao.Queries.GET_USER_BY_TEAM_ID;
import static com.cid.dao.Queries.CREATE_USER;
import static com.cid.dao.Queries.GET_ALL_USERS;
import static com.cid.dao.Queries.DELETE_USER_BY_ID;
import static com.cid.dao.Queries.UPDATE_USER_BY_ID;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cid.beans.UserDto;
import com.cid.dao.helpers.UserRowMapper;
import com.cid.model.User;

@Repository()
public class UserDaoJdbcSupportImpl extends JdbcDaoSupport implements UserDao{

	
	@Autowired
	private UserRowMapper userRowMapper;
	
	@Autowired
	private DataSource dataSource;	
	
	@PostConstruct
	public void init(){
		this.setDataSource(dataSource);
	}
	
	@Override
	public User findById(int id) {
		return getJdbcTemplate().queryForObject(GET_USER_BY_ID,new Object[] { id }, userRowMapper);	
	}

	@Override
	public List<User> findByTeamId(int teamId) {
		return getJdbcTemplate().query(GET_USER_BY_TEAM_ID,new Object[] { teamId }, userRowMapper);	
	}
	
	@Override
	public void createUser(UserDto newUser) {
		getJdbcTemplate().update(CREATE_USER, newUser.getDepartmentId(), newUser.getTeamId(), newUser.getRoleId(), newUser.getFirstname(), newUser.getLastname(), newUser.getUsername(), newUser.getPassword());
	}

	@Override
	public List<User> loadAllUsers() {
		return getJdbcTemplate().query(GET_ALL_USERS, userRowMapper);		
	}

	@Override
	public void deleteUser(int id) {
		getJdbcTemplate().update(DELETE_USER_BY_ID, id);		
	}

	@Override
	public void updateUser(int id, UserDto userToUpdate) {
		getJdbcTemplate().update(UPDATE_USER_BY_ID, userToUpdate.getDepartmentId(), userToUpdate.getTeamId(), userToUpdate.getRoleId(), userToUpdate.getFirstname(), userToUpdate.getLastname(), userToUpdate.getUsername(), userToUpdate.getPassword(), id);
	}

}
