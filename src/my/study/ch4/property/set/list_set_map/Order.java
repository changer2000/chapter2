package my.study.ch4.property.set.list_set_map;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Order {
	
	private Integer orderId;
	private List<Product> productList;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
}
