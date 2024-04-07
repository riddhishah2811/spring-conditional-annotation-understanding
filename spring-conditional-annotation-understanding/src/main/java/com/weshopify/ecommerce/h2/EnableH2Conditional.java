package com.weshopify.ecommerce.h2;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnableH2Conditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String dbType = System.getProperty("dbType");
		System.out.println("DB Type is "+dbType);
		return dbType!=null && dbType.contentEquals("H2");
	}

}
