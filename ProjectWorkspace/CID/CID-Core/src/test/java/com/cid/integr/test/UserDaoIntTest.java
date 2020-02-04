package com.cid.integr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cid.beans.UserDto;
import com.cid.config.AppConfigIntegrationTestEnv;
import com.cid.service.UserService;
import com.cid.utils.BeanMappingUtils;
import com.cid.utils.CidMocks;

public class UserDaoIntTest {

	
	@Test
	public void testSaveUser() {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigIntegrationTestEnv.class);
		UserService userService =context.getBean(UserService.class);
		UserDto userDto=BeanMappingUtils.model2Dto(CidMocks.mockUser());
		userService.saveUser(userDto);
	}
	
}
