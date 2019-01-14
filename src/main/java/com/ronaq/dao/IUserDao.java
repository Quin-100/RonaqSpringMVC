package com.ronaq.dao;

import com.ronaq.model.Login;
import com.ronaq.model.User;

public interface IUserDao {	
	public boolean chkUserForRegistration(User user);
	public void createUser(User user);
	public boolean chkUserForLogin(Login login);

}
