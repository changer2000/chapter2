package com.baobaotao.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class PatternResourceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource[] rsAry = resolver.getResources("classpath*:appl*.xml");
			for (Resource r : rsAry) {
				System.out.println(r.getDescription());
			}
		} catch (Exception e) {
			
		}
		
	}

}
