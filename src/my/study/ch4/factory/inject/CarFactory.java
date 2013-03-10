package my.study.ch4.factory.inject;

import my.study.ch3.beanfactory.Car;

public class CarFactory {
	
	public Car createCar() {
		Car car = new Car();
		car.setBrand("红旗CA72");
		return car;
	}
	
	public static Car createCar2() {
		Car car = new Car();
		car.setBrand("红旗CA73");
		return car;
	}
}
