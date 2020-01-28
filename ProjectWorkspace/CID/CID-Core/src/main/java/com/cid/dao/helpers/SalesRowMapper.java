package com.cid.dao.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cid.model.Sales;

public class SalesRowMapper implements RowMapper<Sales> {
	
	@Override
	public Sales mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sales sales = new Sales();
		sales.setId(rs.getLong("id"));		
		sales.setUserId(rs.getLong("user_id"));
		sales.setTeamId(rs.getLong("team_id"));
		sales.setDate(rs.getDate("date"));
		sales.setWeek(rs.getInt("week"));		
		sales.setEurPerHour(rs.getInt("eur_per_hour"));
		sales.setPaxPerHour(rs.getInt("pax_per_hour"));
		sales.setEurPerPax(rs.getInt("eur_per_pax"));
		sales.setCallsPerHour(rs.getInt("calls_per_hour"));		
		return sales;
	}
	

}
