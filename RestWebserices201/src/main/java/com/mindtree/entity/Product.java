package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity (name="PRODUCTS")
public class Product {
	
	@Id 
	@Column (name ="PRODUCT_ID")
	int productId;
	

	@Column (name ="PRODUCT_NAME" )
	String productName;
	
	@Column (name="CATEGORY")
	String productCategory;
	
	@Column (name ="PRICE")
	Double price;
	
	@Column(name="STOCK_NUMBER")
	int stockNumber;
	
	@Column(name="REMARKS")
	String remarks;
	
	
	public Product() {
		super();
	}
	public Product(String productName, int productId, String productCategory, Double price, int stockNumber,
			String remarks) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.productCategory = productCategory;
		this.price = price;
		this.stockNumber = stockNumber;
		this.remarks = remarks;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
