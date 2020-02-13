package com.cid.test.utils;

import com.cid.model.Sales;
import com.cid.model.User;

public class CidMocks {

	public static User mockUser(){
		User mock = new User();		
		mock.setFirstname("Sina");
		mock.setLastname("Oled");
		mock.setUsername("sina.oled@cid.com");
		mock.setPassword("oled");
		return mock;
	}		
	
	public static User mockUser2(){
		User mock = new User();		
		mock.setFirstname("Peeter");
		mock.setLastname("Suslik");
		mock.setUsername("peeter.suslik@cid.com");
		mock.setPassword("suslik1234");
		return mock;
	}

	public static User mockUser3() {
		User mock = new User();			
		mock.setFirstname("Liina");
		mock.setLastname("Juba");
		mock.setUsername("liina.juba@cid.com");
		mock.setPassword("juba1234");
		return mock;
	}	
	
	public static Sales mockSales() {
		Sales mock = new Sales();
		mock.setId(50L);
		mock.setDate("2020-02-13");
		mock.setWeek(7);
		mock.setEurPerHour(400);
		mock.setPaxPerHour(16);
		mock.setEurPerPax(40);
		mock.setCallsPerHour(15);
		return mock;
	}
}