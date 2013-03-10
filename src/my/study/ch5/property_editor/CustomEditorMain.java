package my.study.ch5.property_editor;

import my.study.ch3.beanfactory.Boss;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomEditorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch5/property_editor/custom_editor_config.xml");
		Boss boss = (Boss) context.getBean("boss");
		System.out.println(boss);

	}

}
