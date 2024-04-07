package com.weshopify.ecom.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.weshopify.ecommerce.config.AppConfig;
import com.weshopify.ecommerce.config.UserDao;

public class AppConfigTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserDao userDao = context.getBean(UserDao.class);
		System.out.println(userDao.getAllUserNames());
		for(String beanNames: context.getBeanDefinitionNames()) {
			System.out.println(beanNames);
		}
	}
}
 