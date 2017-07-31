package com.rajh.rcf.service;

import com.rajh.rcf.pojo.User_t;

public interface User_tMapperService {
	public User_t getUserById(int userId); 
	
	public int add(String username,String password,int age);
}
