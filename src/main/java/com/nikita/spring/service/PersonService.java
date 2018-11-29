package com.nikita.spring.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.nikita.spring.model.Person;

public interface PersonService {

    public void addPerson(Person p);

    public void updateP(Person p);

    public Person getpersonById(int id);

    public void delete(int id);

    public List<Person> displayAll();

    public List<Person> searchByName(String name);

    public Person getpersonByemail(String email);

    public String generateOtp();
    
//    public Person getPersonID(int personID);

}
