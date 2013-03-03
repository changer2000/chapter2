package my.study.ch6.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGreetingThrowsAdviceByXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch6/advice/beans.xml");
		ForumService waiter = (ForumService) context.getBean("forumService");
		waiter.removeForum(10);
		waiter.updateForum(20);
	}

}
