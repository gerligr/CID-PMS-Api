package com.cid.dao;

import static com.cid.dao.Queries.GET_SALES_BY_USER_ID;
import static com.cid.dao.Queries.GET_SALES_BY_TEAM_ID;
import static com.cid.dao.Queries.GET_SALES_BY_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cid.dao.helpers.SalesRowMapper;
import com.cid.model.Sales;

@Repository
public class SalesDaoImpl implements SalesDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SalesRowMapper salesRowMapper;	
	
	@Override
	public List<Sales> findByUserId(Long userId){
		return jdbcTemplate.query(GET_SALES_BY_USER_ID,new Object[] { userId },salesRowMapper);			
	}
	
	@Override 
	public List<Sales> findByTeamId(Long teamId) { 
		return jdbcTemplate.query(GET_SALES_BY_TEAM_ID,new Object[] { teamId },salesRowMapper); 
	}
	  
	 @Override public Sales findById(Long id) { 
		return jdbcTemplate.queryForObject(GET_SALES_BY_ID,new Object[] { id },salesRowMapper); 
	}
	 


}

	


