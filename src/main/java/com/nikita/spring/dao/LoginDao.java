package com.nikita.spring.dao;

import com.nikita.spring.model.Login;

public interface LoginDao 
{
	public boolean checkLogin(String userName,String userPassword);

}
