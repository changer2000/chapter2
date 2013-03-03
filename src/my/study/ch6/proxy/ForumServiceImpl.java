package my.study.ch6.proxy;

public class ForumServiceImpl implements ForumService {
	
	public void removeTopic(int topicId) {
		System.out.println("模拟删除Topic记录：" + topicId);
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void removeForum(int formuId) {
		System.out.println("模拟删除Forum记录：" + formuId);
		try {
			Thread.sleep(40);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
	
}
