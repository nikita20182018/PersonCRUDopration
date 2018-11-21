package com.nikita.spring1;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nikita.spring.model.Person;
import com.nikita.spring.service.LoginService;
import com.nikita.spring.service.PersonService;


@Controller
public class LoginController
{
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService ls;
	@Autowired
   private PersonService ps;

	public void setloginService(LoginService ls)
	  {
		this.ls=ls;
	  }
	public void setpersonService(PersonService ps)
	  {
		  this.ps=ps;
	  }
	
	 @RequestMapping(value="/home", method = RequestMethod.GET)
	  public ModelAndView homepg(Model m)
	  {
		  String message = "Welcome to the world of Home Page.";
	      return new ModelAndView("Home", "message", message); 
		
	  }
	 
	 
  
	 
	 
	 
	 @RequestMapping(value="/login",  method = RequestMethod.POST)
	  public ModelAndView login()
	  {
		 ModelAndView mav = new ModelAndView("login");  
		 Person person = new Person();
		 mav.addObject("person", person);
		 String userType[] = {"Employee", "Admin"};
		 mav.addObject("userTypes", userType);
	      return mav;
		
	  }
	
	

	 @RequestMapping(value="/authenticate" , method = RequestMethod.POST)
	 public ModelAndView authenticate(@ModelAttribute("person")Person person,HttpServletRequest request, HttpServletResponse response,Map<String, Object> map)
	 {
		/**
		 * validate whether person is in database and person user and password are matching
		 */
		
		  boolean isValidUser =ls.checkLogin(person.getEmail(), person.getPassword());
		  
		 if(isValidUser)
		 {
			if(person.getUserType().equals("Admin"))
			{ 
			 /**
			  * Get all data required for Person jsp and set in ModelAndView
			  */
			 request.setAttribute("loginuser" , person.getEmail());
			 
			 ModelAndView mav = new ModelAndView("Person"); 
			 List<Person> listPerson = ps.displayAll();
			 mav.addObject("plist", listPerson);
			 mav.setViewName("Person");
		/*	 
			String fname=person.getFname();
			 String lname=person.getLname();
			 String country=person.getCountry();
			 String email1=person.getEmail();
			 String password=person.getPassword();
			 long phone=person.getPhone();
			 String cpass=person.getCpass();
			 String userType=person.getUserType();
			map.put("person", person);*/
			 
			
			  return mav;
			}
			
			else
			{
				ModelAndView mav = new ModelAndView("edituser"); 
			    person = ps.getpersonByemail(person.getEmail());
		 	    mav.addObject("person",person);
		 	   return mav;
		 	   
			
			}
	
			
		}
		 else 
		 {
			return login(); 
		 }
		 
		
		  
	  
	     
		 
		 
	 }
	  @RequestMapping(value="/edituser/{id}", method= RequestMethod.POST)
	     public ModelAndView updateperson(@ModelAttribute Person person, @PathVariable Integer id)
	  {

		  ModelAndView modelAndView = new ModelAndView("Person");
		  ps.updateP(person);
	      String message = "Peson was successfully edited.";
	      modelAndView.addObject("message", message);
	       return modelAndView;
	       
	  }
}
