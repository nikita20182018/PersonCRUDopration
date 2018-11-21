package com.nikita.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikita.spring.model.Person;

@Repository
public class PersonDaoImpl implements PersonDAO
{

	private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
 public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	@Override
	public void addPerson(Person p)
	{
	  Session s=this.sessionFactory.getCurrentSession();
	   s.persist(p);
	 logger.info("Details of person is successfully save");
	
		
	}

	@Override
	public void updateP(Person p)
	{
	   Session s=this.sessionFactory.getCurrentSession();
	   Person person=getpersonById(p.getId());
	   person.setFname(p.getFname());
	   person.setLname(p.getLname());
	   person.setCountry(p.getCountry());
	   person.setEmail(p.getEmail());
	   person.setPassword(p.getPassword());
	   person.setPhone(p.getPhone());
	   person.setCpass(p.getCpass());
	   s.update(person);
	   logger.info("Details are updated");
	 
	
		
	}

	@Override
	public Person getpersonById(int id)
	{
		Session s=this.sessionFactory.getCurrentSession();
		Person p=(Person) s.get(Person.class,id);
		logger.info("Details loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void  delete(int id) 
	{
		Session s=this.sessionFactory.getCurrentSession();
		Person p=(Person) s.load(Person.class,new Integer(id));
		if(p!=null)
		{
			s.delete(p);
		}
		else
		{
			logger.info("Person details are not present");
		}
		logger.info("details of Persons are deleted succesfully");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> displayAll() 
	{
		Session s=this.sessionFactory.getCurrentSession();
	   return s.createQuery("FROM Person").list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Person> searchByName(String name) 
	{
		Session s=this.sessionFactory.getCurrentSession();
		/*// for single search only
		Criteria criteria = s.createCriteria(Person.class);
		criteria.add(Restrictions.like("fname", name, MatchMode.ANYWHERE));
		return criteria.list();*/
		
		String query="from Person p where p.fname like '" +name+"%' or p.lname like '"+name+"%' or p.country like'"+name+"%' or p.email like'" +name+"%' or p.password like'" +name+"%' or p.phone like'" +name+"%' or p.userType like'" +name+"%'";
		return s.createQuery(query).list();		
		
		
	}


	@Override
	public Person getpersonByemail(String email) {
		  Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
	        criteria.add(Restrictions.like("email", email));
	        return (Person) criteria.uniqueResult();
	    }


	@Override
	public String generateOtp() 
	{
		/*String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
		String numbers = "0123456789"; 
				//String symbols = "!@#$%^&*_=+-/.?<>)"; 
				
				Random random = new Random();
			      char[] otp = new char[length];

			      for(int i = 0; i< length ; i++) {
			         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
			      }
			      return otp;
			   }*/

		int randomPIN = (int)(Math.random()*9000)+1000;
		String val = ""+randomPIN;
		return val;	

	}


	

	/*@Override
	public String email(final String username, final String password)
	{
		return null;
	}
		*/

}
	
	


	
		
	


