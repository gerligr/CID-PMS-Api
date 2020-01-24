package com.cid.dao;

public class Queries {

	
	public static final String GET_USER_BY_ID="select * from USER where id=?";	
	public static final String GET_USER_BY_TEAM_ID="select * from USER where team_id=?";
	public static final String CREATE_USER="insert into USER (department_id,team_id,role_id,firstname,lastname,username,password) VALUES (?,?,?,?,?,?,?)";
	public static final String GET_ALL_USERS="select * from USER";
	public static final String DELETE_USER_BY_ID="delete from user WHERE id=?";
	public static final String UPDATE_USER_BY_ID="UPDATE user SET department_id=?, team_id=?, role_id=?, firstname=?, lastname=?, username=?, password=? WHERE id=?";
	
	public static final String GET_SALES_BY_USER_ID="select * from SALES where user_id=?";
	public static final String GET_SALES_BY_TEAM_ID="select * from SALES where team_id=?";
	public static final String GET_SALES_BY_ID="select * from SALES where id=?";
	
}
