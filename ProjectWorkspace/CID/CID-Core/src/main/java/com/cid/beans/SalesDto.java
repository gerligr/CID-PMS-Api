package com.cid.beans;

import java.util.Date;

import lombok.Data;

@Data
public class SalesDto {
	private Long id;	
	private String date;
	private int week;
	private String month;
	private int eurPerHour;
	private int paxPerHour;
	private int eurPerPax;
	private int callsPerHour;	
	
	private UserDto user;
}
