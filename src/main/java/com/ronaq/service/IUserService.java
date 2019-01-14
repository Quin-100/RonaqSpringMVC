package com.ronaq.service;

import com.ronaq.model.Login;
import com.ronaq.model.User;

public interface IUserService {

	public boolean chkUserForRegistration(User user);
	public void createUser(User user);
	public boolean chkUserForLogin(Login login);
}
