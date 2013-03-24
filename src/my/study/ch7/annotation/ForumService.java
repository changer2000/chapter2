package my.study.ch7.annotation;

public class ForumService {
	
	@NeedTest(value=true, message={"haha"})
	public void deleteForum(int forumId) {
		System.out.println("删除论坛模块" + forumId);
	}
	
	@NeedTest(value=false, message={})
	public void deleteTopic(int topicId) {
		System.out.println("删除论坛主题" + topicId);
	}
	
}
