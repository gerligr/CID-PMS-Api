package com.cid.integr.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cid.beans.SalesDto;
import com.cid.beans.SalesSearchDto;
import com.cid.beans.UserDto;
import com.cid.model.Sales;
import com.cid.service.SalesService;
import com.cid.test.config.AppConfigIntegrationTestEnv;
import com.cid.test.utils.CidMocks;
import com.cid.utils.BeanMappingUtils;

public class SalesDaoIntTest {
	
	private SalesSearchDto salesSearchDto;
	
	@Test
	public void testSearchSales() {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigIntegrationTestEnv.class);
		SalesService salesService = context.getBean(SalesService.class);
		SalesDto salesDto = BeanMappingUtils.salesModel2Dto(CidMocks.mockSales());		
		
		UserDto userDto = new UserDto();		
		userDto.setId(60L);		
		salesDto.setUser(userDto);		
		
		List<Sales> sales = salesService.findAllSales();
		System.out.println("Sales are " + sales.toString());				
	}
			
}
