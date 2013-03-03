package my.study.ch4.annotation;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class LogoutService {
	
	private UserDAO userDao;
	private LogDAO logDao;
	

	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("userDao=" + ToStringBuilder.reflectionToString(userDao))
			.append("\r\n")
			.append("logDao=" + ToStringBuilder.reflectionToString(logDao));
		return buf.toString();
	}
	
	@Autowired
	public void setUserDao(@Qualifier("userDao1") UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	public void setLogDao(LogDAO logDao) {
		this.logDao = logDao;
	}
}
