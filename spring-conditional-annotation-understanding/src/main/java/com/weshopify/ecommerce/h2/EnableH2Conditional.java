package com.weshopify.ecommerce.h2;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnableH2Conditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//		String dbType = System.getProperty("dbType");
//		System.out.println("DB Type is "+dbType);
//		return dbType!=null && dbType.contentEquals("H2");
		boolean enableH2 = false;
		try {
			Class<?> h2Driver = Class.forName("org.h2.Driver");
			if(h2Driver!=null) {
				System.out.println("Driver evaluating by conditional is:\t"+h2Driver.getName());
				enableH2 = true;
			}
		} catch (ClassNotFoundException e) {
			enableH2 = false;
		}
		return enableH2;
	}

}
