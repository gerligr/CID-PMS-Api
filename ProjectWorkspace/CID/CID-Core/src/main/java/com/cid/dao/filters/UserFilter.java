package com.cid.dao.filters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.cid.beans.UserSearchDto;
import com.cid.model.User;

public class UserFilter implements Specification<User>{

	
	private UserSearchDto filters;
	
	public UserFilter (UserSearchDto filters) {
		this.filters=filters;
	}
	
	@Override
	public Predicate toPredicate(Root<User> userTable, CriteriaQuery<?> query, CriteriaBuilder cb) {
		query.distinct(true);
		
		List<Predicate> predicates = new ArrayList<>();
		 
		if(this.filters.getDepartmentId()!=null) {
			Predicate filterByDepartmentId=cb.equal(userTable.get("departmentId"), this.filters.getDepartmentId());				
			predicates.add(filterByDepartmentId);
		}
		
		if(this.filters.getTeamId()!=null) {
			Predicate filterByTeamId=cb.equal(userTable.get("teamId"), this.filters.getTeamId());			
			predicates.add(filterByTeamId);
		}		
	
		 return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

}
