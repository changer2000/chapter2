package my.study.ch7.firstaspectj;

import my.study.ch6.advice.NaiveWaiter;
import my.study.ch6.advice.Waiter;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Waiter target = new NaiveWaiter();
		
		AspectJProxyFactory factory = new AspectJProxyFactory();
		
		factory.setTarget(target);
		factory.addAspect(PreGreetingAspect.class);
		
		Waiter proxy = factory.getProxy();
		proxy.greetTo("Tom");
		proxy.serverTo("John");
	}

}
