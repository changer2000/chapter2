package my.study.ch6.advice;

import java.sql.SQLException;

public class ForumService {
	
	public void removeForum(int forumId) {
		throw new RuntimeException("运行异常");
	}
	
	public void updateForum(int forumId) throws Exception {
		throw new SQLException("数据更新异常");
	}
	
}
