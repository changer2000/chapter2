package my.study.ch6.advice.myexample;

import my.study.ch6.advice.Waiter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMonitorableExampleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch6/advice/myexample/beans-encrypt.xml");
		Waiter waiter = (Waiter) context.getBean("waiter");
		for (int i=0; i<5; i++) {
			waiter.greetTo("Tom");
			try {
				Thread.sleep(10*1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
