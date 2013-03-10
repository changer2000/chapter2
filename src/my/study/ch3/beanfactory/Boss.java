package my.study.ch3.beanfactory;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Boss {
	
	private String name;
	private Car car;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
}
