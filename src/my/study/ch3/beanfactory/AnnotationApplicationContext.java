package my.study.ch3.beanfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContext {
	private static final Log logger = LogFactory.getLog(AnnotationApplicationContext.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		Car car = context.getBean(Car.class);

		if (logger.isDebugEnabled())
			logger.debug(">>> init, Car : " + car);
		
		car.setMaxSpeed(280);
		if (logger.isDebugEnabled())
			logger.debug(">>> change maxSpeed, Car : " + car);
		

		Car car2 = (Car) context.getBean("car");
		if (logger.isDebugEnabled())
			logger.debug(">>> init Car2 : " + car2);	//因为是单例，所以这里的maxSpeed是280
	}

}
