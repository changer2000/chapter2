package my.study.ch6.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		System.out.println("How are you! Mr." + args[0]);
		Object obj = invocation.proceed();
		System.out.println(">>> return object = " + obj);
		System.out.println("Please enjoy yourself.");
		return obj;
	}

}
