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

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import com.cid.beans.UserSearchDto;
import com.cid.model.User;

public class UserFilter implements  Specification<User>{

	
	private UserSearchDto filters;
	
	public UserFilter (UserSearchDto filters) {
		this.filters=filters;
	}
	
	@Override
	public Predicate toPredicate(Root<User> userTable, CriteriaQuery<?> query, CriteriaBuilder cb) {
		query.distinct(true);
		
		List<Predicate> predicates = new ArrayList<>();
		 
		if(this.filters.getDepartmentId()!=null) {
			Predicate filterByActive=cb.equal(userTable.get("department_id"), this.filters.getDepartmentId());				
			predicates.add(filterByActive);
		}
		
		if(this.filters.getTeamId()!=null) {
			Predicate filterByActive=cb.equal(userTable.get("team_id"), this.filters.getTeamId());			
			predicates.add(filterByActive);
		}		
	
		 return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

}
