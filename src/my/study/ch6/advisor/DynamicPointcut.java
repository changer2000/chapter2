package my.study.ch6.advisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import my.study.ch6.advice.Waiter;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class DynamicPointcut extends DynamicMethodMatcherPointcut {
	
	private static List<String> specialClientList = new ArrayList<String>();
	static {
		specialClientList.add("Tom");
		specialClientList.add("John");
	}
	
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> clazz) {
				System.out.println("调用getClassFilter()对" + clazz.getName() + "做静态检查");
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}
	
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("调用matches(method,clazz)对" + targetClass.getName() + "." + method.getName() + "做静态检查");
		return "greetTo".equals(method.getName());
	}
	
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		System.out.println("调用matches(method, clazz, args)对" + targetClass.getName() + "." + method.getName()
				+ "做动态检查");
		
		String clientName = (String) args[0];
		return specialClientList.contains(clientName);
	}

}
