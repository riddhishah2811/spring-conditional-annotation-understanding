package com.weshopify.ecommerce.mysql;

import java.util.Arrays;
import java.util.List;

import com.weshopify.ecommerce.config.UserDao;

public class MysqlUserDao implements UserDao {

	@Override
	public List<String> getAllUserNames() {
		// TODO Auto-generated method stub
		return Arrays.asList("mysql-user1","mysql-user2");
	}

}
