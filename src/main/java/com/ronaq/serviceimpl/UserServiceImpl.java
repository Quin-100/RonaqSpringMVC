package com.ronaq.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ronaq.dao.IUserDao;
import com.ronaq.model.Login;
import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	IUserDao userDao;	
	
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	

	public boolean chkUserForRegistration(User user) {
		// TODO Auto-generated method stub
		return userDao.chkUserForRegistration(user);
	}
	
	@Transactional
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDao.createUser(user);
	}


	public boolean chkUserForLogin(Login login) {
		// TODO Auto-generated method stub
		return userDao.chkUserForLogin(login);
	}



	

}
