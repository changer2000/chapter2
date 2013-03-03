package my.study.ch4.property.set;

import my.study.ch3.beanfactory.Boss;
import my.study.ch3.beanfactory.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertySetMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch3/beanfactory/beans.xml");
		Car car7 = (Car) context.getBean("car7");
		System.out.println(car7);
		
		Boss boss1 = (Boss) context.getBean("boss1");
		System.out.println(boss1);

		Boss boss2 = (Boss) context.getBean("boss2");
		System.out.println(boss2);

		Boss boss3 = (Boss) context.getBean("boss3");
		System.out.println(boss3);
	}

}
