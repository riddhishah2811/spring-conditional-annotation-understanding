package com.weshopify.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.weshopify.ecommerce.h2.EnableH2Conditional;
import com.weshopify.ecommerce.h2.H2UserDao;
import com.weshopify.ecommerce.mysql.EnableMysqlConditional;
import com.weshopify.ecommerce.mysql.MysqlUserDao;

@Configuration
public class AppConfig {
	
	@Bean
	@Conditional(EnableMysqlConditional.class)
	public UserDao mysqlUserDao() {
		return new MysqlUserDao();
	}
	
	@Bean
	@Conditional(EnableH2Conditional.class)
	public UserDao h2UserDao() {
		return new H2UserDao();
	}
}
