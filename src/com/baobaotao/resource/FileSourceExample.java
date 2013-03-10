package com.baobaotao.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

public class FileSourceExample {
	
	public static void main(String[] args) {
		try {
			String filename = "D:/eclipse37/workspace/chapter2/build/classes/log4j.xml";
			Resource res1 = new FileSystemResource(filename);
			
			Resource res2 = new ClassPathResource("log4j.xml");
			
			EncodedResource er1 = new EncodedResource(res1, "utf-8");	//, "utf-8"
			EncodedResource er2 = new EncodedResource(res2, "utf-8");	//, "utf-8"
			
			System.out.println("res1:" + res1.getFilename());
			System.out.println("res2:" + res2.getFilename());
			
			System.out.println("er1:" + FileCopyUtils.copyToString(er1.getReader()));
			System.out.println("er2:" + FileCopyUtils.copyToString(er2.getReader()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


