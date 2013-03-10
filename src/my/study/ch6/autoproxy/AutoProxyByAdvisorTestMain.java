package my.study.ch6.autoproxy;

import my.study.ch6.advice.Seller;
import my.study.ch6.advice.Waiter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoProxyByAdvisorTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch6/autoproxy/beans-by-advisor.xml");
		Waiter waiter = (Waiter) context.getBean("waiter");
		waiter.greetTo("Jone");
		waiter.serverTo("Jone");
		
		Seller seller = (Seller) context.getBean("seller");
		seller.greetTo("Tom");
	}

}
