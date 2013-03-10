package my.study.ch3.beanfactory.lifecycle;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Animal implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	
	private static final Log logger = LogFactory.getLog(Animal.class);
	
	private String name;
	private String color;
	private int maxSpeed;
	
	private BeanFactory beanFactory;
	private String beanName;
	
	public Animal() {
		logger.debug("2. 调用Animal()构造函数");
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		logger.debug("7. 调用BeanFactoryAware.setBeanFactory()");
		this.beanFactory = beanFactory;
	}
	
	@Override
	public void setBeanName(String name) {
		logger.debug("6. 调用BeanNameAware.setBeanName()");	
		this.beanName = name;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("9. 调用InitializingBean.afterPropertiesSet()");
	}

	@Override
	public void destroy() throws Exception {
		logger.debug("13. 调用DisposableBean.destroy()");
	}
	
	public void introduce() {
		logger.debug("12. introduce() : " + ToStringBuilder.reflectionToString(this));
	}
	
	public void myInit() {
		logger.debug("10. 调用init-method指定的myInit()方法，将maxSpeed设为240");
		this.maxSpeed = 240;
	}
	
	public void myDestroy() {
		logger.debug("14. 调用destroy-method指定的myDestroy()方法");
		this.maxSpeed = 240;
	}
	
	public String getName() {
		logger.debug("调用getName()");
		return name;
	}
	public void setName(String name) {
		logger.debug("5. 调用setName()");	//因为beans.xml文件里有对name的属性设置
		this.name = name;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		
		this.maxSpeed = maxSpeed;
	}
	
}
