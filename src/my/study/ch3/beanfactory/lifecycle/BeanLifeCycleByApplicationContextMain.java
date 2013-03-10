package my.study.ch3.beanfactory.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleByApplicationContextMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch3/beanfactory/beans.xml");
		Animal animal = (Animal) context.getBean("animal");
		System.out.println(animal);
	}

}
