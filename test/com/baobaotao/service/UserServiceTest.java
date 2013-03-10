package com.baobaotao.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})	//这个文件要放在test的目录里，否则spring找不到。不过，后来在src目录下，随便改下applicationContext.xml，然后保存，就好了
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testHasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "111");
		assertTrue(b1);
		assertFalse(b2);
	}

	@Test
	public void testFindUserByUserName() {
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}

}
