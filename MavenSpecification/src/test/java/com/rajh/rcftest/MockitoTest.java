package com.rajh.rcftest;

import org.junit.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.rajh.rcf.dao.SignonDao;
import com.rajh.rcf.service.SignonService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockitoTest {
	
	@Autowired
	private SignonService ss;
	
	private SignonDao sd;
	
	
	@Test
	public void mockTest(){
		sd = mock(SignonDao.class);
		String a = "a";
		when(sd.findAll()).thenReturn(Lists.newArrayList(a));
		List<String> list1 = sd.findAll();
		assertEquals(1, list1.size());
//		sd.findAll();
//		verify(sd, atLeast(2)).findAll();
	}
}
