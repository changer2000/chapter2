package my.study.ch6.advisor.autoproxycreator;

import my.study.ch6.advice.Seller;
import my.study.ch6.advice.Waiter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoProxyCreatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch6/advisor/autoproxycreator/beans.xml");
		Waiter waiter = (Waiter) context.getBean("waiter");
		Seller seller = (Seller) context.getBean("seller");
		waiter.greetTo("Jane");
		seller.greetTo("Jonth");
	}

}
