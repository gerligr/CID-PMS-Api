package com.cid.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cid.config.AppConfigCid;
import com.cid.dao.SalesDao;
import com.cid.model.Sales;

public class SalesService {

	public static void main(String[] args) {

		salesDaoImplByName("salesDaoImpl");
	}

	private static void salesDaoImplByName(String daoBeanImpl) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigCid.class);

		SalesDao salesDao = context.getBean(daoBeanImpl,SalesDao.class);

		List<Sales> sales = salesDao.findByUserId(60L);
		System.out.println("Users are " + sales.toString());
		
		/*
		 * List<Sales> teamSales = salesDao.findByTeamId(3L);
		 * System.out.println("Found "+teamSales.toString());
		 * 
		 * Sales sales1= salesDao.findById(9L);
		 * System.out.println("Found "+sales1.toString());
		 */
		 
	}

}
