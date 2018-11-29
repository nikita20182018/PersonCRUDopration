package com.nikita.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikita.spring.dao.PersonDAO;
import com.nikita.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService
{
	@Autowired
	private PersonDAO pd;

	
	@Override
	@Transactional
	public void addPerson(Person p) 
	{
		pd.addPerson(p);
		
	}

	@Override
	@Transactional
	public void updateP(Person p)
	{
		 pd.updateP(p);
		
	}

	@Transactional
	public Person getpersonById(int id) 
	{
		Person p=pd.getpersonById(id);
		return p;
	}

	@Transactional
	public void delete(int id)
	{
	
		pd.delete(id);
		
	}

	@Transactional
	public List<Person> displayAll()
	{
	
	return pd.displayAll();
	}
	 public void setPersonDAO(PersonDAO pd) 
	 {
		 this.pd=pd;
	 }

	@Override
	@Transactional
	  public List<Person> searchByName(String name)
	{
		
		return pd.searchByName(name);
	}

	@Override
	@Transactional
	public Person getpersonByemail(String email) {
		
		return pd.getpersonByemail(email);
	}

	@Override
	public String generateOtp() {
		
		return pd.generateOtp();
	}

//    public Person getPersonID(int personID) {
//    
//        return pd.getPersonId(personID);
//    }

	
}
