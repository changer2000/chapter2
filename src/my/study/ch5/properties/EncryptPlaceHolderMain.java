package my.study.ch5.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

public class EncryptPlaceHolderMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch5/properties/beans-encrypt.xml");
		
		UserService userSvc = (UserService) context.getBean("userService");
		User user = userSvc.findUserByUserName("admin");
		System.out.println(user);
	}
}
