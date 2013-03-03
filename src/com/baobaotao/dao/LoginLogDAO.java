package com.baobaotao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.LoginLog;

@Repository
public class LoginLogDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertLoginLog(LoginLog loginLog) {
		String sql = "INSERT INTO T_LOGIN_LOG(USER_ID,IP,LOGIN_DATETIME) " +
				" VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()});
	}
	
	
}
