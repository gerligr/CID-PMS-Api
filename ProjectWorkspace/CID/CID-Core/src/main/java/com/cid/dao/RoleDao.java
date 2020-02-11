package com.cid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cid.model.Role;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {

}
