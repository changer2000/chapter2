package my.study.ch6.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class TestBeforeAdvice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Waiter target = new NaiveWaiter();
		BeforeAdvice advice = new GreetingBeforeAdvice();
		ProxyFactory pf = new ProxyFactory();
		pf.setInterfaces(target.getClass().getInterfaces());	//指定用jdk动态代理
		pf.setOptimize(true);	//指定用cglib
		pf.setTarget(target);
		pf.addAdvice(advice);
		
		Waiter proxy = (Waiter) pf.getProxy();
		proxy.greetTo("John");
		proxy.serverTo("Tom");
	}

}
