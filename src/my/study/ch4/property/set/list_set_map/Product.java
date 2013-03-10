package my.study.ch4.property.set.list_set_map;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Product {
	
	private Integer productId;
	private String name;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
