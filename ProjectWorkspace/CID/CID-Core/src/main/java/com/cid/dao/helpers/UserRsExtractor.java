package com.cid.dao.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cid.model.Sales;
import com.cid.model.User;

public class UserRsExtractor implements ResultSetExtractor<Map<Long, User>>{

	@Override
	public Map<Long, User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<Long, User> tableAsMap = new HashMap<>();
		
		while(rs.next()) {
			
			Long userId = rs.getLong("id");
			User user= tableAsMap.get(userId);
			
			if(user==null) {
				user = mapIntoNewUser(rs);
				tableAsMap.put(userId,user);
			}
			Sales sales = mapIntoSales(rs);
			user.getSalesList().add(sales);
			
		}
		
		return tableAsMap;
		
	}
	
	private User mapIntoNewUser(ResultSet rs) throws SQLException, DataAccessException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setLastname(rs.getString("lastname"));
		user.setDepartmentId(rs.getLong("department_id"));
		return user;
	}

	private Sales mapIntoSales(ResultSet rs) throws SQLException, DataAccessException {
		Sales sales = new Sales();
		sales.setId(rs.getLong("id"));
		sales.setDate(rs.getDate("date"));
		sales.setWeek(rs.getInt("week"));
		sales.setEurPerHour(rs.getInt("eur_per_hour"));
		sales.setPaxPerHour(rs.getInt("pax_per_hour"));
		sales.setEurPerPax(rs.getInt("eur_per_pax"));
		sales.setCallsPerHour(rs.getInt("calls_per_hour"));
		return sales;
	}

	
	

}
