package my.study.ch3.beanfactory.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	
	private static final Log logger = LogFactory.getLog(MyBeanFactoryPostProcessor.class);
	
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		BeanDefinition bd = beanFactory.getBeanDefinition("animal");
		bd.getPropertyValues().addPropertyValue("name", "美洲虎");
		logger.debug("******调用BeanFactoryPostProcessor.postProcessBeanFactory()!");
		
	}
	
	
	
}
