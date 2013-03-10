package my.study.ch3.beanfactory;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Car {
	
	private String brand;
	private String color;
	private Integer maxSpeed;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
}
