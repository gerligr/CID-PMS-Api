package com.cid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cid.dao.filters.SalesFilter;
import com.cid.model.Sales;
import com.cid.model.User;

public interface SalesDao extends JpaRepository<Sales,Long>, JpaSpecificationExecutor<Sales>  {

	//List<Sales> searchByFilters(SalesFilter salesFilter);
	
	List<Sales> findByUser(User user);
}

