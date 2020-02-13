package com.cid.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cid.beans.SalesDto;
import com.cid.beans.SalesSearchDto;
import com.cid.dao.SalesDao;
import com.cid.dao.filters.SalesFilter;
import com.cid.model.Sales;
import com.cid.model.User;
import com.cid.utils.BeanMappingUtils;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SalesService {
	
	@Autowired
	private SalesDao salesDao;
	
	public List<SalesDto> searchSales(SalesSearchDto filters){
		
		/*
		return salesDao.findAll(new SalesFilter(filters)) 
	                .stream()
	                .map(BeanMappingUtils::salesModel2Dto)
	                .collect(Collectors.toList());		
	     */
		User searchUser = new User();
		searchUser.setId(filters.getUserId());
		
		return salesDao.findByUser(searchUser) 
                .stream()
                .map(BeanMappingUtils::salesModel2Dto)
                .collect(Collectors.toList());		

	}	
	
	public List<Sales> findAllSales(){
		return salesDao.findAll();		
	}
	
}
