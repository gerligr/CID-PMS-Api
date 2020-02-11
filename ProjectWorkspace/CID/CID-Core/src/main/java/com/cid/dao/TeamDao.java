package com.cid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cid.model.Department;
import com.cid.model.Team;

@Repository
public interface TeamDao extends JpaRepository<Team,Long> {	
	
	List<Department> findByDepartmentId(Long departmentId);

}
