package com.cid.model;

import lombok.Data;

@Data
public class UserSales {
	private long userId;
	private double avgWeeklyEurSales;
	private double avgWeeklyPaxSales;
	private double avgWeeklyExtraSales;
	private double avgWeeklyCalls;
	private double avgMonthlyEurSales;
	private double avgMonthlyPaxSales;
	private double avgMonthlyExtraSales;
	private double avgMonthlyCalls;
	
	private Sales sales;

}
