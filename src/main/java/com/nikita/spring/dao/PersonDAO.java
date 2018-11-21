package com.nikita.spring.dao;

import java.util.List;

import com.nikita.spring.model.Person;

public interface PersonDAO 
{
	public void addPerson(Person p);

    public void updateP(Person p);
    public Person getpersonById(int id);
    public void delete(int id);
    public List<Person> displayAll();
    public List<Person> searchByName(String name);
   public Person getpersonByemail(String email);
   public String generateOtp(); 
 // public String email(String username, String password);
}
