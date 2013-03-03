package my.study.ch3.beanfactory.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {
	
	private Log logger = LogFactory.getLog(MyBeanPostProcessor.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		if ("animal".equals(beanName)) {
			Animal car = (Animal) bean;
			if (car.getColor()==null) {
				logger.debug("8. 调用BeanPostProcessor.postProcessBeforeInitialization, color为空，设置为黑色");
				car.setColor("黑色");
			}
		}
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		
		if ("animal".equals(beanName)) {
			Animal car = (Animal) bean;
			if (car.getMaxSpeed()>200) {
				logger.debug("11. 调用BeanPostProcessor.postProcessAfterInitialization, maxSpeed>200，设置为200");
				car.setMaxSpeed(200);
			}
		}
		
		
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
