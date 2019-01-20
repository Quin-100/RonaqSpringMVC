package com.ronaq.daoimpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ronaq.dao.IUserDao;
import com.ronaq.mapper.BenificiaryMapper;
import com.ronaq.model.BeneficiaryData;
import com.ronaq.model.Benificiary;
import com.ronaq.model.Feedback;
import com.ronaq.model.LoanApplication;
import com.ronaq.model.LoanData;
import com.ronaq.model.Login;
import com.ronaq.model.SecurityQuestion;
import com.ronaq.model.User;


@Repository
public class UserDaoImpl implements IUserDao {
	
	private static final Logger logger = 			
			LoggerFactory.getLogger(UserDaoImpl.class);
	
	SessionFactory sessionFactory ;		
	Transaction tx;
	BeanFactory beanFactory;
	NamedParameterJdbcTemplate namedTemplate ;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean chkUserForRegistration(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from User u where u.email=:email and u.password=:password");
		query.setString("email", user.getEmail());
		query.setString("password", user.getPassword());		
		List<User> u = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("User Details="+ user);
		
		if(u.size()>0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		int id = (Integer) session.save(user);
		//httpsession.setAttribute("userid", id);
		tx.commit();
		session.close();
		logger.info("User details saved successfully, User Details="+ user);
	}

	public boolean chkUserForLogin(Login login) {
		// TODO Auto-generated method stub		
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from User u where u.email=:email and u.password=:password");
		query.setString("email", login.getUsername());
		query.setString("password", login.getPassword());
		List<User> u = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("User Details="+ login);		
		
		if(u.size()>0) {			
			return true;
		}
		else {
			return false;
		}
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from User u where u.email=:email");
		query.setString("email", email);		
		List<User> u = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("User Details="+ email);		
		
		if(u.size()>0) {			
			return u.get(0);
		}
		else {
			return null;
		}
	}

	public void updatePassword(String password, int userId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();	
		
		tx = session.beginTransaction();
		
		User user = (User) session.load(User.class,userId);
		user.setPassword(password);
		//bid.setBidId(bidId);
		//bid1 = bid;
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
		logger.info("User Details="+ userId + "--"+ password);
	}

	public void addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		int id = (Integer) session.save(feedback);		
		tx.commit();
		session.close();
		logger.info("Feedback successfully saved ="+ feedback);
	}

	public boolean chkUserBeneficiary(Benificiary benificiary) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		
		
		String query = "select u.id,u.name,u.branch,u.acctype,a.accountno from USER_DETAILS u inner join ACCOUNT_INFO a on u.id = a.id\r\n" + 
				"where u.name = :name and u.branch = :branch and u.acctype = :acctype and a.accountno = :accountno";
		
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setParameter("name", benificiary.getName());
		sqlQuery.setParameter("branch", benificiary.getBranch());
		sqlQuery.setParameter("acctype", benificiary.getAcctype());
		sqlQuery.setParameter("accountno", benificiary.getAccountno());
		
		List<Benificiary> results = sqlQuery.list();		
		tx.commit();
		session.close();
		logger.info("User Details---="+ results);		
		
		if(results.size() == 1) {			
			return true;
		}
		else {
			return false;
		}
		
		

	}

	public void addUserBenificiary(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(user);		
		tx.commit();
		session.close();
		logger.info("Benificiary successfully saved ="+ user);
	}

	public List<Benificiary> getBeneficiaryById(int id,String branch) {
		// TODO Auto-generated method stub
		List<Benificiary> lstBen = new ArrayList<Benificiary>();
		namedTemplate = (NamedParameterJdbcTemplate) beanFactory.getBean("namedTemplateDS");
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		String query;
		
		query = "\r\n" + 
					"select b.id,b.name,b.accountno,b.acctype,b.branch from BENEFICIARY_DETAILS b \r\n" + 
					"inner join USER_BENEFICIARY ub on b.id = ub.beneficiaryId\r\n" + 
					"inner join USER_DETAILS u on u.id = ub.userId\r\n" + 
					"where u.id = :id and u.branch = b.branch";
		
		
		
		SqlParameterSource namedPara = new MapSqlParameterSource("id", id);
		List<Benificiary> benList = (List<Benificiary>) namedTemplate.queryForObject(query, namedPara, new BenificiaryMapper());
		
		//SQLQuery sqlQuery = session.createSQLQuery(query);
	
		
		//sqlQuery.setParameter("id", id);	
		
		//List<Benificiary> results = sqlQuery.list();
		
		tx.commit();
		session.close();
		logger.info("User Beneficiary details-----------="+ benList);		
		
		if(benList.size() > 0) {			
			return benList;
		}
		else {
			return lstBen;
		}	
		
		
		
		
	}

	public List<Benificiary> getBeneficiaryById(int id) {
		// TODO Auto-generated method stub
		List<Benificiary> lstBen = new ArrayList<Benificiary>();
		namedTemplate = (NamedParameterJdbcTemplate) beanFactory.getBean("namedTemplateDS");
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		String query;
		
		query = "\r\n" + 
					"select b.id,b.name,b.accountno,b.acctype,b.branch from BENEFICIARY_DETAILS b \r\n" + 
					"inner join USER_BENEFICIARY ub on b.id = ub.beneficiaryId\r\n" + 
					"inner join USER_DETAILS u on u.id = ub.userId\r\n" + 
					"where u.id = :id and u.branch != b.branch";		
	
		
		SqlParameterSource namedPara = new MapSqlParameterSource("id", id);
		List<Benificiary> benList = (List<Benificiary>) namedTemplate.queryForObject(query, namedPara, new BenificiaryMapper());
		
		//SQLQuery sqlQuery = session.createSQLQuery(query);
	
		
		//sqlQuery.setParameter("id", id);	
		
		//List<Benificiary> results = sqlQuery.list();
		
		tx.commit();
		session.close();
		logger.info("User Beneficiary details-----------="+ benList);		
		
		if(benList.size() > 0) {			
			return benList;
		}
		else {
			return lstBen;
		}	
		
		
	}

	public double getUserBalance(String accountno) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addUserTransaction(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(user);		
		tx.commit();
		session.close();
		logger.info("Transaction successfully done ="+ user);
	}
	
	public double getBalanceByAccNo(String accno) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("select a.balance from Account a where a.accountNo = :accountno");
		query.setString("accountno", accno);		
		List<Double> u = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("User Balance Details="+ u.get(0));		
		
		if(u.size()>0) {			
			return u.get(0);
		}
		else {
			return 0;
		}		
	}

	public void updateBenificiaryBalance(String benaccountno,double amount) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		//tx = session.beginTransaction();
		
		Query qry = session.createQuery("update Account a set a.balance=:amount where a.accountNo=:accountno");
		qry.setParameter("amount",amount);
		qry.setParameter("accountno", benaccountno);
		int res = qry.executeUpdate();	
			
		//tx.commit();
		session.close();
		logger.info("Transaction successfully done..");
		
	}
	
	public Benificiary getBen(int id) {
		
		
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		
		
		String query = "select * from Benificiary b where b.id =:id";
		
		Query sqlQuery = session.createSQLQuery(query);
		sqlQuery.setParameter("id", id);
		
		List<Benificiary> results = sqlQuery.list();		
		tx.commit();
		session.close();
		logger.info("Benificiary Details---="+ results);		
		
		if(results.size() == 1) {			
			return results.get(0);
		}
		else {
			return null;
		}
		
	}

	public void addLoan(LoanData loanData) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		int id = (Integer) session.save(loanData);
		//httpsession.setAttribute("userid", id);
		tx.commit();
		session.close();
		logger.info("Loan added successfully, Loan Details="+ loanData);
	}

	public List<LoanData> getLoan() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from LoanData order by loanId");
				
		List<LoanData> u = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("User Details="+u.get(0));		
		
		if(u.size()>0) {			
			return u;
		}
		else {
			return null;
		}
	}
	
	public LoanData getLoanById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from LoanData l where l.loanId = :id order by loanId");
		query.setParameter("id",id);
		List<LoanData> u = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("Loan Details="+u.get(0));		
		
		if(u.size()>0) {			
			return u.get(0);
		}
		else {
			return null;
		}
	}

	public void addLoanApplication(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(user);		
		tx.commit();
		session.close();
		logger.info("Loan Application successfully done ="+ user);
	}

	public List<SecurityQuestion> getSecurityQuestions() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from SecurityQuestion order by questionId");
				
		List<SecurityQuestion> u = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("Security Questions ="+u);		
		
		if(u.size()>0) {			
			return u;
		}
		else {
			return null;
		}
	}

	public boolean chkUserForForgotPassword(String email, String secques, String ans) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from User u where u.email=:email and u.securityQuestion=:secques and u.securityAnswer=:ans");
		query.setString("email", email);
		query.setString("secques", secques);
		query.setString("ans", ans);
		
		List<User> u = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("User Details="+ email +" , "+ secques +" , "+ ans);		
		
		if(u.size()>0) {			
			return true;
		}
		else {
			return false;
		}
	}

	public List<LoanApplication> getLoanApplications() {
		// TODO Auto-generated method stub
		List<LoanApplication> lstloan = new ArrayList<LoanApplication>();
		
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from LoanApplication order by applicationId");
				
		lstloan = query.list();
		//session.save(user);
		tx.commit();
		session.close();
		logger.info("Loan applications ="+lstloan);		
		
		if(lstloan.size()>0) {			
			return lstloan;
		}
		else {
			return lstloan;
		}
	}

	public void approveLoan(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();	
		
		tx = session.beginTransaction();
		
		LoanApplication loan = (LoanApplication) session.load(LoanApplication.class,id);
		loan.setStatus("Approved");
		//bid.setBidId(bidId);
		//bid1 = bid;
		session.saveOrUpdate(loan);
		tx.commit();
		session.close();
		logger.info("Loan Details="+ loan );
	}

	public void rejectLoan(int id) {
		// TODO Auto-generated method stub
Session session = this.sessionFactory.openSession();	
		
		tx = session.beginTransaction();
		
		LoanApplication loan = (LoanApplication) session.load(LoanApplication.class,id);
		loan.setStatus("Rejected");
		//bid.setBidId(bidId);
		//bid1 = bid;
		session.saveOrUpdate(loan);
		tx.commit();
		session.close();
		logger.info("Loan Details="+ loan);
	}

	

}
