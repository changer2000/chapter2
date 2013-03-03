package my.study.ch6.proxy.jdk;

import java.lang.reflect.Proxy;

import my.study.ch6.proxy.ForumService;
import my.study.ch6.proxy.ForumServiceImpl;

public class PerformanceTestMain {
	
	public static void main(String[] args) {
		ForumService target = new ForumServiceImpl();
		
		PerformanceHandler handle = new PerformanceHandler(target);
		
		ForumService proxy = (ForumService) Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				handle);
		proxy.removeForum(10);
		proxy.removeTopic(1012);
	}
	
}
