package com.cid.utils;

import com.cid.beans.RoleDto;
import com.cid.beans.SalesDto;
import com.cid.beans.TeamDto;
import com.cid.beans.UserDto;
import com.cid.model.Role;
import com.cid.model.Sales;
import com.cid.model.Team;
import com.cid.model.User;

public class BeanMappingUtils {

	
	public static User dto2Model(UserDto dto) {
		User user = new User();
		if (dto.getId() != null) {
			user.setId(dto.getId());
		}
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());	
		user.setTeam(teamDto2Model(dto.getTeam())); 
		user.setRole(roleDto2Model(dto.getRole()));		 
		return user;
	}

	public static UserDto model2Dto(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setFirstname(user.getFirstname());
		dto.setLastname(user.getLastname());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());		
		dto.setTeam(teamModel2Dto(user.getTeam()));
		dto.setRole(roleModel2Dto(user.getRole()));
		return dto;
	}
	
	public static Team teamDto2Model(TeamDto teamDto) {
		Team team = new Team();
		team.setId(teamDto.getId());
		team.setName(teamDto.getName());				
		return team;
	}
	
	public static TeamDto teamModel2Dto(Team team) {
		TeamDto teamDto = new TeamDto();
		teamDto.setId(team.getId());
		teamDto.setName(team.getName());
		return teamDto;
	} 
	
	public static Role roleDto2Model(RoleDto roleDto) {
		Role role = new Role();
		role.setId(roleDto.getId());
		role.setName(roleDto.getName());
		return role;
	}
	
	public static RoleDto roleModel2Dto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setId(role.getId());
		roleDto.setName(role.getName());
		return roleDto;
	}
	
	public static Sales salesDto2Model(SalesDto salesDto) {
		Sales sales = new Sales();
		sales.setId(salesDto.getId());
		sales.setDate(salesDto.getDate());
		sales.setWeek(salesDto.getWeek());
		sales.setEurPerHour(salesDto.getEurPerHour());
		sales.setPaxPerHour(salesDto.getPaxPerHour());
		sales.setEurPerPax(salesDto.getEurPerPax());
		sales.setCallsPerHour(salesDto.getCallsPerHour());
		sales.setUser(dto2Model(salesDto.getUser()));
		return sales;
	}
	
	public static SalesDto salesModel2Dto(Sales sales) {
		SalesDto salesDto = new SalesDto();
		salesDto.setId(sales.getId());
		salesDto.setDate(sales.getDate());
		salesDto.setWeek(sales.getWeek());
		salesDto.setEurPerHour(sales.getEurPerHour());
		salesDto.setPaxPerHour(sales.getPaxPerHour());
		salesDto.setEurPerPax(sales.getEurPerPax());
		salesDto.setCallsPerHour(sales.getCallsPerHour());
		salesDto.setUser(model2Dto(sales.getUser()));
		return salesDto;
	}
	
	
	
}
	
	
	