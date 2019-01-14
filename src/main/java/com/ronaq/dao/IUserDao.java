package com.ronaq.dao;

import com.ronaq.model.Login;
import com.ronaq.model.User;

public interface IUserDao {
	
	public void createUser(User user);
	public boolean chkUser(Login login);

}
