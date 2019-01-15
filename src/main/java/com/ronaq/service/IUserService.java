package com.ronaq.service;

import com.ronaq.model.Feedback;
import com.ronaq.model.Login;
import com.ronaq.model.User;

public interface IUserService {

	public boolean chkUserForRegistration(User user);
	public void createUser(User user);
	public boolean chkUserForLogin(Login login);
	
	public User findUserByEmail(String email);
	public void updatePassword(String password, Integer id);
	
	public void addFeedback(Feedback feedback);
}
