package com.inspur.springboot.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:/testbean/testbean.properties")
@ConfigurationProperties(prefix = "user")
public class TestBean {

	// @Value("${user.productName}")
	// public String productName;
	//
	// @Value("${user.productDate}")
	// public Long productDate = (long) 11111.0;
	//
	// @Value("${user.productWidth}")
	// public String productWidth = "bbbb";
	//
	// @Value("${user.productHeight}")
	// public String productHeight = "cccc";
	//
	// public String getProductName() {
	// return productName;
	// }
	//
	// public void setProductName(String productName) {
	// this.productName = productName;
	// }
	//
	// public Long getProductDate() {
	// return productDate;
	// }
	//
	// public void setProductDate(Long productDate) {
	// this.productDate = productDate;
	// }
	//
	// public String getProductWidth() {
	// return productWidth;
	// }
	//
	// public void setProductWidth(String productWidth) {
	// this.productWidth = productWidth;
	// }
	//
	// public String getProductHeight() {
	// return productHeight;
	// }
	//
	// public void setProductHeight(String productHeight) {
	// this.productHeight = productHeight;
	// }

	public String productName;

	public Long productDate = (long) 11111.0;

	public String productWidth = "bbbb";

	public String productHeight = "cccc";

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductDate() {
		return productDate;
	}

	public void setProductDate(Long productDate) {
		this.productDate = productDate;
	}

	public String getProductWidth() {
		return productWidth;
	}

	public void setProductWidth(String productWidth) {
		this.productWidth = productWidth;
	}

	public String getProductHeight() {
		return productHeight;
	}

	public void setProductHeight(String productHeight) {
		this.productHeight = productHeight;
	}
}
