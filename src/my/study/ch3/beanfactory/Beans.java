package my.study.ch3.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	
	@Bean(name="car")
	public Car buildCar() {
		Car car = new Car();
		car.setBrand("红旗CA72");
		return car;
	}
	
}
