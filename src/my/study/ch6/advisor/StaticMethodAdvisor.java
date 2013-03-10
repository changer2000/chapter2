package my.study.ch6.advisor;

import java.lang.reflect.Method;

import my.study.ch6.advice.Waiter;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

public class StaticMethodAdvisor extends StaticMethodMatcherPointcutAdvisor {

	private static final long serialVersionUID = 7072153677182988909L;

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "greetTo".equals(method.getName());
	}
	
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> clazz) {
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}
}
