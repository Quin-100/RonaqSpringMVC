package com.ronaq.dao;

import java.util.List;

import com.ronaq.model.Benificiary;
import com.ronaq.model.Feedback;
import com.ronaq.model.LoanApplication;
import com.ronaq.model.LoanData;
import com.ronaq.model.Login;
import com.ronaq.model.SecurityQuestion;
import com.ronaq.model.User;

public interface IUserDao {	
	
	public boolean chkUserForRegistration(User user);
	public void createUser(User user);
	public boolean chkUserForLogin(Login login);
	
	public User findUserByEmail(String email);
	
	public void updatePassword(String password, int userId);
	
	public void addFeedback(Feedback feedback);
	
	public boolean chkUserBeneficiary(Benificiary benificiary);
	
	public void addUserBenificiary(User user);
	
	public List<Benificiary> getBeneficiaryById(int id,String branch);
	
	public List<Benificiary> getBeneficiaryById(int id);
	
	public void addUserTransaction(User user);
	
	public double getBalanceByAccNo(String accno);
	
	public void updateBenificiaryBalance(String benaccountno,double amount);
	
	//temp
	public Benificiary getBen(int id);
	
	//temp
	public void addLoan(LoanData loanData);
	
	
	public List<LoanData> getLoan();
	
	public LoanData getLoanById(int id);
	
	public void addLoanApplication(User user);
	
	public List<SecurityQuestion> getSecurityQuestions();
	
	public boolean chkUserForForgotPassword(String email,String secques,String ans);
	
	public List<LoanApplication> getLoanApplications();
	
	public void approveLoan(int id);
	
	public void rejectLoan(int id);
	

}
