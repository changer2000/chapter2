package my.study.ch4.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch4/annotation/annotation-beans.xml");
		LogonService service = (LogonService) context.getBean("logonService");
		System.out.println(service);
		
		LogoutService logoutService = (LogoutService) context.getBean("logoutService");
		System.out.println(logoutService);
	}

}
