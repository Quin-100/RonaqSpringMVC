package com.ronaq.service;

import com.ronaq.model.Login;
import com.ronaq.model.User;

public interface IUserService {

	public void createUser(User user);
	public boolean chkUser(Login login);
}
