package my.study.ch4.property.set.list_set_map;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListSetMapMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/study/ch4/property/set/list_set_map/collection-beans.xml");
		Order order1 = (Order) context.getBean("order1");
		System.out.println(order1);
		
		Order order2 = (Order) context.getBean("order2");
		System.out.println(order2);
		
		Set<String> favorite = (Set<String>) context.getBean("favorite");
		System.out.println(favorite.size());
		System.out.println(ToStringBuilder.reflectionToString(favorite));
		
		Map emails1 = (Map) context.getBean("emails1");
		System.out.println(emails1.size());
		System.out.println(ToStringBuilder.reflectionToString(emails1));
	}

}
