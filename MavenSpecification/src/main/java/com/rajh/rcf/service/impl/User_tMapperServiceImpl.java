package com.rajh.rcf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rajh.rcf.dao.User_tMapper;
import com.rajh.rcf.pojo.User_t;
import com.rajh.rcf.service.User_tMapperService;

@Service
public class User_tMapperServiceImpl implements User_tMapperService {

	@Resource
	private User_tMapper user_tMapper;
	
	
	public User_t getUserById(int userId) {
		return this.user_tMapper.selectByPrimaryKey(userId);
	}


	public int add(String username, String password, int age) {
		User_t u = new User_t();
		u.setUserName(username);
		u.setPassword(password);
		u.setAge(age);
		return this.user_tMapper.insert(u);
	}

}
