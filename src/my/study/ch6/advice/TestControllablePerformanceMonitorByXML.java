package my.study.ch6.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestControllablePerformanceMonitorByXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch6/advice/beans.xml");
		my.study.ch6.proxy.ForumService waiter = (my.study.ch6.proxy.ForumService) context.getBean("forumService2");
		waiter.removeForum(10);
		//waiter.updateForum(20);
		
		Monitorable moniterable = (Monitorable) waiter;
		moniterable.setMonitorActive(true);
		
		waiter.removeForum(10);

	}

}
