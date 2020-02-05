package com.cid.integr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cid.beans.UserDto;
import com.cid.service.UserService;
import com.cid.test.config.AppConfigIntegrationTestEnv;
import com.cid.test.utils.CidMocks;
import com.cid.utils.BeanMappingUtils;

public class UserDaoIntTest {

	
	@Test
	public void testSaveUser() {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigIntegrationTestEnv.class);
		UserService userService =context.getBean(UserService.class);
		UserDto userDto=BeanMappingUtils.model2Dto(CidMocks.mockUser());
		userService.saveUser(userDto);
				
	}
	
		
}
