package com.cid.beans;

import lombok.Data;

@Data
public class SalesGoalsDto {
	private long id;
	private int week;
	private int eurPerHour;
	private int paxPerHour;
	private int eurPerPax;
	private int callsPerHour;	
	
}

