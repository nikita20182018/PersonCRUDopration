package com.nikita.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikita.spring.dao.LoginDao;
import com.nikita.spring.model.Login;


@Service
public class LoginServiceImpl implements LoginService
{
  
	 @Autowired
	private LoginDao ld;
	
	 public void setLoginDAO(LoginDao  ld) 
	 {
		this.ld=ld;
	 }

	@Override
	public boolean checkLogin(String userName, String userPassword) {
	
		return ld.checkLogin(userName, userPassword);
	}

	

	 


}
