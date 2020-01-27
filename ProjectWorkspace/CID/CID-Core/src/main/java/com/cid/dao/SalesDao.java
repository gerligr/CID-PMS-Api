package com.cid.dao;

import java.util.List;

import com.cid.model.Sales;

public interface SalesDao {
	
	List<Sales> findByUserId(Long userId);	
	
	List<Sales> findByTeamId(Long teamId);
	
	Sales findById(Long id);

}
