package com.cid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cid.beans.UserDto;
import com.cid.model.UserModel;

import course.jse.jdbc.utils.DbUtils;
import lombok.Setter;

@Repository
public class UserDaoImpl implements UserDao {		
	
	/* @Autowired */	
	@Setter
	private DataSource dataSource;
		
	@Override
	public void createUser(UserDto newUser) {		
				
        Connection conn =null;
        			
		try{
			conn =  dataSource.getConnection();
			
			System.out.println("Connected to Database...");        
         
            PreparedStatement pstNewUser = conn.prepareStatement("INSERT INTO USER (department_id,team_id,role_id,firstname,lastname,username,password) " +
																	"VALUES (?,?,?,?,?,?,?)");   
            pstNewUser.setInt(1, newUser.getDepartmentId());
            pstNewUser.setInt(2, newUser.getTeamId());
            pstNewUser.setInt(3, newUser.getRoleId());
            pstNewUser.setString(4, newUser.getFirstname());
            pstNewUser.setString(5, newUser.getLastname());
            pstNewUser.setString(6, newUser.getUsername());
            pstNewUser.setString(7, newUser.getLastname());
            
            pstNewUser.executeUpdate();	 		
            
        }
        catch (Exception e){
           
        	System.err.println ("Impossible to connect to Database");
        	 e.printStackTrace();            
        }
        finally {
        	DbUtils.closeConnection(conn); 
        }

	}
	
	@Override
	public void loadAllUsers(){		
			
        Connection conn =null;
			
		try
		{				
			conn = dataSource.getConnection();
			
			System.out.println ("Connected to Database..."); 
			
			PreparedStatement pstAllUsers = conn.prepareStatement("SELECT * from user");			
	
			ResultSet res = pstAllUsers.executeQuery();	
			
			while (res.next()) {
	        	
	        	System.out.print("\t"+res.getString("firstname"));
	        	System.out.print("\t"+res.getString("lastname"));
		        System.out.println();
			}	
		}
		
		catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
			
		} finally {
			 DbUtils.closeConnection(conn);    
		}
		
	}

	@Override
	public UserDto findById(int id) {
		Connection conn = null;
		UserDto found = null;
			
		try{
				
			conn = dataSource.getConnection();
			
			System.out.println ("Connected to Database..."); 
			
			PreparedStatement pstOneUser = conn.prepareStatement("SELECT * from user WHERE id=?");
			pstOneUser.setInt(1, id);
			
			ResultSet res = pstOneUser.executeQuery();

			if (res.next()) {
				
				found = new UserDto();
				found.setDepartmentId(res.getInt("department_id"));
				found.setTeamId(res.getInt("team_id"));
				found.setRoleId(res.getInt("role_id"));
				found.setFirstname(res.getString("firstname"));
				found.setLastname(res.getString("lastname"));
				found.setUsername(res.getString("username"));
				found.setPassword(res.getString("password"));	
				
				System.out.println("User is found!  " + found.toString());
			}
		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			 DbUtils.closeConnection(conn);    
		}
		return found;		
	}
	
	@Override
	public void deleteUser(int id) {
		Connection conn = null;
		
		try{
				
			conn = dataSource.getConnection();
			
			System.out.println ("Connected to Database..."); 
			
			PreparedStatement pstOneUser = conn.prepareStatement("DELETE from user WHERE id=?");
			pstOneUser.setInt(1, id);
			
			pstOneUser.executeUpdate();			
			            
        }
        catch (Exception e){
           
        	System.err.println ("Impossible to connect to Database");
        	 e.printStackTrace();            
        }
        finally {
           DbUtils.closeConnection(conn);         
        }
		
	}
	
	@Override
	public void updateUser(int id, UserDto userToUpdate) {
		
		Connection conn =null;
		
		try{
			
			conn = dataSource.getConnection();
			
			System.out.println ("Connected to Database..."); 
			
			PreparedStatement pstOneUser = conn.prepareStatement("UPDATE user SET department_id=?, team_id=?, role_id=?, firstname=?, lastname=?, username=?, password=? WHERE id=?");
			pstOneUser.setInt(1, userToUpdate.getDepartmentId());
			pstOneUser.setInt(2, userToUpdate.getTeamId());
			pstOneUser.setInt(3, userToUpdate.getRoleId());
			pstOneUser.setString(4, userToUpdate.getFirstname());
			pstOneUser.setString(5, userToUpdate.getLastname());
			pstOneUser.setString(6, userToUpdate.getUsername());
			pstOneUser.setString(7, userToUpdate.getPassword());    
			pstOneUser.setInt(8, id);	
			
			int rowsUpdated = pstOneUser.executeUpdate();	            
	        
	        System.out.println("Updated "+rowsUpdated+ "rows in User Table");	                
            
        }
        catch (Exception e){
           
        	System.err.println ("Impossible to connect to Database");
        	 e.printStackTrace();            
        }
        finally {
           DbUtils.closeConnection(conn);         
        }
		
	}

	@Override
	public ArrayList<UserModel> findByTeamId(int teamId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	/*	
	
	@Override
	public ArrayList<UserModel> findByTeamId(int teamId) {
		
		Connection conn = null;
		ArrayList<UserModel> userList = new ArrayList<UserModel>();
			
		try{
				
			conn = DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "select * from user where team_id= " + teamId;

			ResultSet res = cmd.executeQuery(sql);

			while (res.next()) {				
				UserModel foundUser = new UserModel();
				foundUser.setDepartmentId(res.getInt("department_id"));
				foundUser.setTeamId(res.getInt("team_id"));
				foundUser.setRoleId(res.getInt("role_id"));
				foundUser.setFirstname(res.getString("firstname"));
				foundUser.setLastname(res.getString("lastname"));
				foundUser.setUsername(res.getString("username"));
				foundUser.setPassword(res.getString("password"));				
				
				userList.add(foundUser);
			}
		}
		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			 DbUtils.closeConnection(conn);    
		}
		return userList;
	}	
	
	*/

}
