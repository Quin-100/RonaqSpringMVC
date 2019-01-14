package com.ronaq.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ronaq.dao.IUserDao;
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

	public void createUser(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		logger.info("User details saved successfully, User Details="+ user);
	}

	public boolean chkUser(Login login) {
		// TODO Auto-generated method stub
		logger.info(login.getUsername() + login.getPassword());
		Session session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from User u where u.name=:name and u.password=:password");
		query.setString("name", login.getUsername());
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

	

}
