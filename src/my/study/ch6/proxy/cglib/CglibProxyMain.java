package my.study.ch6.proxy.cglib;

import my.study.ch6.proxy.ForumServiceImpl;

public class CglibProxyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		ForumServiceImpl service = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
		service.removeForum(10);
		service.removeTopic(1023);
	}

}
