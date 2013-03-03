package com.baobaotao.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.LoginLogDAO;
import com.baobaotao.dao.UserDAO;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private LoginLogDAO loginLogDao;
	
	public boolean hasMatchUser(String userName, String password) {
		int matchCount = userDao.getMatchCount(userName, password);
		return matchCount>0;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	
	public void loginSuccess(User user) {
		user.setCredits(5+ (user.getCredits()==null? 0 : user.getCredits().intValue()));
		userDao.updateLoginInfo(user);
		
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		loginLogDao.insertLoginLog(loginLog);
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public LoginLogDAO getLoginLogDao() {
		return loginLogDao;
	}

	public void setLoginLogDao(LoginLogDAO loginLogDao) {
		this.loginLogDao = loginLogDao;
	}
	
}
