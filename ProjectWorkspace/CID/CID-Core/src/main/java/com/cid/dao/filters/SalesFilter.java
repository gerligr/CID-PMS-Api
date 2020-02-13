package com.cid.dao.filters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.cid.beans.SalesSearchDto;
import com.cid.model.Sales;
import com.cid.model.User;

public class SalesFilter implements Specification<Sales>{

	private SalesSearchDto filters;
	
	public SalesFilter (SalesSearchDto filters) {
		this.filters = filters;
	}
	
	@Override
	public Predicate toPredicate(Root<Sales> salesTable, CriteriaQuery<?> query, CriteriaBuilder cb) {
		query.distinct(true);
		
		List<Predicate> predicates = new ArrayList<>();
		 
		if(this.filters.getUserId()!=null) {	
			Predicate filterByUser = cb.equal(salesTable.get("user").get("id"), this.filters.getUserId());			
			predicates.add(filterByUser);		    	    
		}		 
		
		
	    return cb.and(predicates.toArray(new Predicate[predicates.size()]));		
	}

}
