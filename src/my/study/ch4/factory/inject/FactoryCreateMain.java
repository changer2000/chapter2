package my.study.ch4.factory.inject;

import my.study.ch3.beanfactory.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryCreateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch3/beanfactory/beans.xml");
		
		Car car5 = (Car) context.getBean("car5");
		System.out.println(car5);
		
		Car car6 = (Car) context.getBean("car6");
		System.out.println(car6);
	}

}
