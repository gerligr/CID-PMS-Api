package com.cid.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.cid.beans.UserDto;
import com.cid.dao.helpers.UserRowMapper;
import com.cid.model.User;

@Repository
public class UserDaoNamedParametersJdbcTemplate implements UserDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private UserRowMapper userRowMapper;	
	
	//private SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("cid").usingGeneratedKeyColumns("id");

	@Override
	public User findById(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return namedJdbcTemplate.queryForObject("select * from USER where id=:id", params, userRowMapper);
	}

	@Override
	public List<User> findByTeamId(Long teamId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("team_id", teamId);
		return namedJdbcTemplate.query("select * from USER where team_id=:team_id", namedParameters, userRowMapper);
	}

	@Override
	public void createUser(UserDto newUser) {
		throw new UnsupportedOperationException("Not yet implemented");
		
		/* Map<String, Object> objMap = new HashMap<String, Object>();
		 objMap.put("department_id", newUser.getDepartmentId());
		 objMap.put("team_id", newUser.getTeamId()); 
		 objMap.put("role_id", newUser.getRoleId()); 
		 objMap.put("firstname", newUser.getFirstname());
		 objMap.put("lastname", newUser.getLastname()); 
		 objMap.put("username", newUser.getUsername()); 
		 objMap.put("password", newUser.getPassword());
		 
		
		 simpleJdbcInsert.executeAndReturnKey(objMap);	*/	 
		 		 
	}

	@Override
	public List<User> loadAllUsers() {
		return namedJdbcTemplate.query("select * from USER", userRowMapper);

	}

	@Override
	public void deleteUser(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		namedJdbcTemplate.update("delete from USER where id=:id", params);
	}
	
	@Override
	public void updateUser(Long id, UserDto userToUpdate) {
		throw new UnsupportedOperationException("Not yet implemented");

	}

}
