package com.rajh.rcf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.rajh.rcf.dao.SignonDao;
import com.rajh.rcf.service.SignonService;

public class SignonServiceImpl implements SignonService{
	
	@Resource
	private SignonDao sd;
	
	public List<String> findAll() {
		return this.sd.findAll();
		
	}

}
