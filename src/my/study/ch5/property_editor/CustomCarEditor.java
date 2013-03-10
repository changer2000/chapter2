package my.study.ch5.property_editor;

import java.beans.PropertyEditorSupport;

import my.study.ch3.beanfactory.Car;

public class CustomCarEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		//super.setAsText(text); 这句话不注释掉，会出错
		
		if (text==null || text.indexOf(",")==-1) {
			throw new IllegalArgumentException("设置的字符串格式不正确");
		}
		
		String[] infos = text.split(",");
		Car car = new Car();
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setColor(infos[2]);
		
		setValue(car);
	}
	
	
	
}
