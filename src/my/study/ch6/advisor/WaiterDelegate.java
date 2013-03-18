package my.study.ch6.advisor;

import my.study.ch6.advice.Waiter;

public class WaiterDelegate {
	
	private Waiter waiter;
	
	public void service(String clientName) {
		waiter.greetTo(clientName);
		waiter.serverTo(clientName);
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	
}
