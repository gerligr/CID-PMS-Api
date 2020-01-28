package com.cid.beans;

import java.util.Date;

import lombok.Data;

@Data
public class SalesDto {
	private Long id;
	private Long userId;
	private Long teamId;
	private Date date;
	private int week;
	private int eurPerHour;
	private int paxPerHour;
	private int eurPerPax;
	private int callsPerHour;	
		
}
