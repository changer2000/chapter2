package my.study.ch6.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAfterAdviceByXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch6/advice/beans.xml");
		Waiter waiter = (Waiter) context.getBean("waiter2");
		waiter.greetTo("John");
		waiter.serverTo("Tom");
	}

}
