package com.nikita.spring.service;

import com.nikita.spring.model.Login;

public interface LoginService 
{
	public boolean checkLogin(String userName, String userPassword);
	
}


