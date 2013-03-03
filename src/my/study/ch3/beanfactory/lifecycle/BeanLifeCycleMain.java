package my.study.ch3.beanfactory.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycleMain {
	
	private static final Log logger = LogFactory.getLog(BeanLifeCycleMain.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("my/study/ch3/beanfactory/beans.xml");
		BeanFactory bf = new XmlBeanFactory(resource);
		
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		Animal animal = (Animal) bf.getBean("animal");
		animal.introduce();
		animal.setColor("红色");
		
		Animal animal2 = (Animal) bf.getBean("animal");
		logger.debug("animal==animal2 ? " + (animal==animal2));
		
		((XmlBeanFactory)bf).destroySingletons();
	}

}
