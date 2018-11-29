package com.nikita.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nikita.spring.model.Person;
import com.nikita.spring.service.PersonService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:E:\\eclips\\Nikita\\PersonCrudOpration\\src\\main\\webapp\\WEB-INF\\spring\\appservlet\\s-context.xml"})
public class TestPersonService {
	
	@Autowired
	PersonService personService;
	
	@Test
	public void testPersonRead() {
		Person p=personService.getpersonByemail("aa");
		if(p==null)
		{
		System.out.println("Person is not present");
		}
		else {
		System.out.println(p);
		}
	}

}
