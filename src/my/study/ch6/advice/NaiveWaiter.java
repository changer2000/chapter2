package my.study.ch6.advice;

public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String name) {
		System.out.println("greet to " + name);
	}

	@Override
	public void serverTo(String name) {
		System.out.println("serving " + name);
	}

}
