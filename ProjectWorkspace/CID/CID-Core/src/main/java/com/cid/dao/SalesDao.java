package com.cid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cid.dao.filters.SalesFilter;
import com.cid.model.Sales;

public interface SalesDao extends JpaRepository<Sales,Long> {

	List<Sales> findAll(SalesFilter salesFilter);

}

