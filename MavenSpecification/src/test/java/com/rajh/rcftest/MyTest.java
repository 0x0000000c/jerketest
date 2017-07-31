package com.rajh.rcftest;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.rajh.rcf.pojo.User_t;
import com.rajh.rcf.service.User_tMapperService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MyTest {
	//private static Logger logger = Logger.getLogger(MyTest.class);
	
	@Resource
	private User_tMapperService userService;
	
	@Test
	public void test1(){
		User_t user = userService.getUserById(1);
		System.out.println(user.getUserName()); 
	    //logger.info(JSON.toJSONString(user));  
	}
}
