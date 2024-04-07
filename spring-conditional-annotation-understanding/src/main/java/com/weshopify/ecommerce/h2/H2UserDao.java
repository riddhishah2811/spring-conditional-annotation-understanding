package com.weshopify.ecommerce.h2;

import java.util.Arrays;
import java.util.List;

import com.weshopify.ecommerce.config.UserDao;

public class H2UserDao implements UserDao {

	@Override
	public List<String> getAllUserNames() {
		// TODO Auto-generated method stub
		return Arrays.asList("h2-user1","h2-user2");
	}

}
