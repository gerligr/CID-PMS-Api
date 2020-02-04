package com.cid.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.cid.config.CidCoreContext;

@SpringBootApplication
@Import(value = {CidCoreContext.class})
public class CidApplication {

	public static void main(String[] args) {
		 SpringApplication.run(CidApplication.class, args);
	}

}
