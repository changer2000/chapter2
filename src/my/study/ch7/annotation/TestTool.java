package my.study.ch7.annotation;

import java.lang.reflect.Method;

public class TestTool {
	
	public static void main(String[] args) {
		Class clazz = ForumService.class;
		Method[] methods= clazz.getDeclaredMethods();
		System.out.println(methods.length);
		for (int i=0; i<methods.length; i++) {
			NeedTest nt = methods[i].getAnnotation(NeedTest.class);
			if (nt!=null) {
				if (nt.value()) {
					System.out.println(methods[i].getName() + " need test.");
					System.out.println(nt.message()[0]);
				} else {
					System.out.println(methods[i].getName() + " need not test.");
				}
			}
		}
	}
	
}
