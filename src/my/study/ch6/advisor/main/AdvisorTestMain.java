package my.study.ch6.advisor.main;

import my.study.ch6.advice.Seller;
import my.study.ch6.advice.Waiter;
import my.study.ch6.advisor.WaiterDelegate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch6/advisor/beans.xml");
		
		/*** StaticMethodMatcherPointercustAdvisor ***/
		Waiter waiter = (Waiter) context.getBean("waiter");
		waiter.greetTo("Tom");
		
		Seller seller = (Seller) context.getBean("seller");
		seller.greetTo("John");
		
		/*** 静态正则表达式方法匹配切面 ***/
		Waiter waiter1 = (Waiter) context.getBean("waiter1");
		waiter1.greetTo("Tommy");
		
		/*** 动态表达式方法匹配切面   ***/
		Waiter waiter2 = (Waiter) context.getBean("waiter2");
		waiter2.greetTo("Qin");
		waiter2.greetTo("Tom");
		
		/*** 控制流程切面 ***/
		System.out.println("控制流程切面");
		Waiter waiter3 = (Waiter) context.getBean("waiter3");
		WaiterDelegate wd = new WaiterDelegate();
		wd.setWaiter(waiter3);
		waiter3.greetTo("Peter");
		waiter3.serverTo("Peter");
		wd.service("Peter");
		
		/*** 复合切点切面 ***/
		System.out.println("复合切点切面");
		Waiter waiter4 = (Waiter) context.getBean("waiter4");
		WaiterDelegate wd4 = new WaiterDelegate();
		wd4.setWaiter(waiter4);
		waiter4.serverTo("Mum");
		waiter4.greetTo("Mum");
		wd4.service("Mum");
	}

}
