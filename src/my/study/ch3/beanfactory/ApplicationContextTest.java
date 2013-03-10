package my.study.ch3.beanfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	private static final Log logger = LogFactory.getLog(ApplicationContextTest.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch3/beanfactory/beans.xml");
		Car car = (Car) context.getBean("car");
		
		if (logger.isDebugEnabled())
			logger.debug(">>> init, Car : " + car);
		
		car.setMaxSpeed(280);
		if (logger.isDebugEnabled())
			logger.debug(">>> change maxSpeed, Car : " + car);
		

		Car car2 = (Car) context.getBean("car");
		if (logger.isDebugEnabled())
			logger.debug(">>> init Car2 : " + car2);
	}

}
