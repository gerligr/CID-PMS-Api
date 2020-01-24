package com.cid.dao;

import java.util.List;

import com.cid.model.Sales;

public interface SalesDto {
	
	List<Sales> findByUserId(int userId);	
	
	List<Sales> findByTeamId(int teamId);
	
	Sales findById(int id);

}
