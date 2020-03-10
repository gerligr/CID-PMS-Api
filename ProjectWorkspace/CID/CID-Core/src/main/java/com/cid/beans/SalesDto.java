package com.cid.beans;

import lombok.Data;

@Data
public class SalesDto {
	private long id;	
	private String date;
	private int week;
	private String month;
	private double eurPerHour;
	private double paxPerHour;
	private double eurPerPax;
	private double callsPerHour;	
	
	private UserDto user;
}
