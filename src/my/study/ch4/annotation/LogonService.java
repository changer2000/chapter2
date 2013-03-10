package my.study.ch4.annotation;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LogonService {
	
	@Autowired
	@Qualifier("userDao2")
	private UserDAO userDao;
	
	@Autowired
	private LogDAO logDao;
		
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("userDao=" + ToStringBuilder.reflectionToString(userDao))
			.append("\r\n")
			.append("logDao=" + ToStringBuilder.reflectionToString(logDao));
		return buf.toString();
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public LogDAO getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDAO logDao) {
		this.logDao = logDao;
	}
	
}
