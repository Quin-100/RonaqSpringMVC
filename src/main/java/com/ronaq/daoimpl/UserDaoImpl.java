package com.ronaq.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ronaq.dao.IUserDao;
import com.ronaq.model.Benificiary;
import com.ronaq.model.Feedback;
import com.ronaq.model.Login;
import com.ronaq.model.User;


@Repository
public class UserDaoImpl implements IUserDao {
	
	private static final Logger logger = 			
			LoggerFactory.getLogger(UserDaoImpl.class);
	
	SessionFactory sessionFactory ;		
	Transaction tx;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean chkUserForRegistration(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from User u where u.email=:email and u.acctype=:acctype");
		query.setString("email", user.getEmail());
		query.setString("acctype", user.getAcctype());
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
		
		
		String query = "select u.name,u.branch,u.acctype,a.accountno from USER_DETAILS u inner join ACCOUNT_INFO a on u.id = a.id\r\n" + 
				"where u.name = :name and u.branch = :branch and u.acctype = :acctype and a.accountno = :accountno";
		
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setParameter("name", benificiary.getName());
		sqlQuery.setParameter("branch", benificiary.getBranch());
		sqlQuery.setParameter("acctype", benificiary.getAcctype());
		sqlQuery.setParameter("accountno", benificiary.getAccountno());
		
		List<Benificiary> results = sqlQuery.list();
		
		/*Query query = session.createQuery("from User u, Account a where u.name=:name and u.accountno=:password");
		query.setString("email", login.getUsername());
		query.setString("password", login.getPassword());
		List<User> u = query.list();
		//session.save(user);*/
		tx.commit();
		session.close();
		logger.info("User Details="+ benificiary);		
		
		if(results.size() == 1) {			
			return true;
		}
		else {
			return false;
		}
	}

	

	

}
