package my.study.ch6.proxy;

public class MethodPerformance {
	
	private long begin;
	private long end;
	private String serviceMethod;
	
	public MethodPerformance(String serviceMethod) {
		this.serviceMethod = serviceMethod;
		this.begin = System.currentTimeMillis();
	}
	
	public void printPerformance() {
		end = System.currentTimeMillis();
		System.out.println(serviceMethod + "花费" + (end-begin) + "毫秒");
	}

}
