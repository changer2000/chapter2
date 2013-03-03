package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

@Repository
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName, String password) {
		String sqlStr = "SELECT COUNT(*) FROM T_USER WHERE USER_NAME=? AND PASSWORD=?";
		return jdbcTemplate.queryForInt(sqlStr, new Object[] {userName, password});
	}
	
	public User findUserByUserName(final String userName) {
		String sqlStr = "SELECT USER_ID,USER_NAME,CREDITS FROM T_USER WHERE USER_NAME=?";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] {userName}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setCredits(rs.getInt("credits"));
			}
		});
		return user;
	}
	
	public void updateLoginInfo(User user) {
		String sqlStr = "UPDATE T_USER SET LAST_VISIT=?, LAST_IP=?, CREDITS=? WHERE USER_ID=?";
		jdbcTemplate.update(sqlStr, new Object[] {user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
	}
}
