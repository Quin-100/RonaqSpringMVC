package com.ronaq.dao;

import com.ronaq.model.Benificiary;
import com.ronaq.model.Feedback;
import com.ronaq.model.Login;
import com.ronaq.model.User;

public interface IUserDao {	
	public boolean chkUserForRegistration(User user);
	public void createUser(User user);
	public boolean chkUserForLogin(Login login);
	
	public User findUserByEmail(String email);
	
	public void updatePassword(String password, int userId);
	
	public void addFeedback(Feedback feedback);
	
	public boolean chkUserBeneficiary(Benificiary benificiary);
	

}
