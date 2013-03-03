package my.study.ch4.annotation;

import org.springframework.stereotype.Component;

@Component("userDao1")
public class UserDAO {
	
	private String name = "userDao default";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
