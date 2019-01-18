package com.ronaq.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ronaq.dao.IUserDao;
import com.ronaq.model.Benificiary;
import com.ronaq.model.Feedback;
import com.ronaq.model.LoanData;
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


	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserByEmail(email);
	}


	public void updatePassword(String password, Integer id) {
		// TODO Auto-generated method stub
		userDao.updatePassword(password, id);
	}


	public void addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		userDao.addFeedback(feedback);
	}


	public boolean chkUserBeneficiary(Benificiary benificiary) {
		// TODO Auto-generated method stub
		return userDao.chkUserBeneficiary(benificiary);
	}


	public void addUserBenificiary(User user) {
		// TODO Auto-generated method stub
		userDao.addUserBenificiary(user);
	}


	public List<Benificiary> getBeneficiaryById(int id,String branch) {
		// TODO Auto-generated method stub
		return userDao.getBeneficiaryById(id,branch);
	}


	public List<Benificiary> getBeneficiaryById(int id) {
		// TODO Auto-generated method stub
		return userDao.getBeneficiaryById(id);
	}


	public void addUserTransaction(User user) {
		// TODO Auto-generated method stub
		userDao.addUserTransaction(user);
	}


	public double getBalanceByAccNo(String accno) {
		// TODO Auto-generated method stub
		return userDao.getBalanceByAccNo(accno);
	}


	public void updateBenificiaryBalance(String benaccountno, double amount) {
		// TODO Auto-generated method stub
		userDao.updateBenificiaryBalance(benaccountno, amount);
	}


	public Benificiary getBen(int id) {
		// TODO Auto-generated method stub
		return userDao.getBen(id);
	}


	public void addLoan(LoanData loanData) {
		// TODO Auto-generated method stub
		userDao.addLoan(loanData);
	}


	public List<LoanData> getLoan() {
		// TODO Auto-generated method stub
		return userDao.getLoan();
	}


	public LoanData getLoanById(int id) {
		// TODO Auto-generated method stub
		return userDao.getLoanById(id);
	}



	

}
