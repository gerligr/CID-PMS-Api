package com.cid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cid.model.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Long>, JpaSpecificationExecutor<Department> {

	

}
