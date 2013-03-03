package my.study.ch6.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class GreetingAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println(">>> target.name=" + target.getClass().getName());
		System.out.println(">>> return object=" + returnValue);
		System.out.println("Please enjoy yourself.");
	}

}
