package com.cid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cid.beans.SalesSearchDto;
import com.cid.dao.SalesDao;
import com.cid.dao.filters.SalesFilter;
import com.cid.model.Sales;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SalesService {
	
	@Autowired
	private SalesDao salesDao;
	
	public List<Sales> searchSales(SalesSearchDto filters){
		return salesDao.findAll(new SalesFilter(filters));		

	}
	
}
