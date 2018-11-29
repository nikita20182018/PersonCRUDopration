package com.nikita.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nikita.spring.model.Login;


@Repository("LoginDao")
public class LoginDaoImpl implements LoginDao
{
	private static final Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
 public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

 protected Session getSession()
 	{
     return sessionFactory.openSession();
 	}

  public boolean checkLogin(String userName,String userPassword) 
  	{
	  Session session = sessionFactory.openSession();
	  boolean userFound = false;
	  String SQL_QUERY ="from Person where email=? and password=?";
	  Query query = session.createQuery(SQL_QUERY);
	  query.setParameter(0,userName);
	  query.setParameter(1,userPassword);
	  List list = query.list();
	
	if ((list != null) && (list.size() > 0))
	{
		userFound= true;
	}

	session.close();
	return userFound;              

  	}


	


}
