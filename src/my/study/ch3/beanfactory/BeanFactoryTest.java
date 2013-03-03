package my.study.ch3.beanfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BeanFactoryTest {
	
	private static final Log logger = LogFactory.getLog(BeanFactoryTest.class);
	
	public static void main(String[] args) {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("classpath:my/study/ch3/beanfactory/beans.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		Car car = (Car) bf.getBean("car");
		if (logger.isDebugEnabled())
			logger.debug(">>> init, Car : " + car);
		
		car.setMaxSpeed(280);
		if (logger.isDebugEnabled())
			logger.debug(">>> change maxSpeed, Car : " + car);
		

		Car car2 = (Car) bf.getBean("car");
		if (logger.isDebugEnabled())
			logger.debug(">>> init Car2 : " + car2);
	}
	
}
