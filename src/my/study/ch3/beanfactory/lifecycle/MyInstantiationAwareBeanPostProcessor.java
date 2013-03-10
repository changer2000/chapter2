package my.study.ch3.beanfactory.lifecycle;

import java.beans.PropertyDescriptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.Ordered;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter implements Ordered {
	
	private static final Log logger = LogFactory.getLog(MyInstantiationAwareBeanPostProcessor.class);
	
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass,
			String beanName) throws BeansException {
		if ("animal".equals(beanName)) {
			logger.debug("1. InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation, beanClass=" + beanClass.getName());
		}
		return super.postProcessBeforeInstantiation(beanClass, beanName);
	}
	
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName)
			throws BeansException {
		if ("animal".equals(beanName)) {
			logger.debug("3. InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInstantiation, bean=" + bean);
		}
		return super.postProcessAfterInstantiation(bean, beanName);
	}
	
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs,
			PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		if ("animal".equals(beanName)) {
			logger.debug("4. InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues, bean=" + bean);
		}
		return super.postProcessPropertyValues(pvs, pds, bean, beanName);
	}

	@Override
	public int getOrder() {
		return 2;	
	}
}
