package my.study.ch4.parent.child.container;

import my.study.ch3.beanfactory.Boss;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParentChildContainerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext pContext = new ClassPathXmlApplicationContext("my/study/ch4/parent/child/container/parent.xml");
		ApplicationContext cContext = new ClassPathXmlApplicationContext(new String[] {"my/study/ch4/parent/child/container/child.xml"}, pContext);
		
		Boss boss1 = (Boss) cContext.getBean("boss1");
		System.out.println(boss1);	//from parent's car

		Boss boss2 = (Boss) cContext.getBean("boss2");
		System.out.println(boss2);	//from child's car
	}

}
