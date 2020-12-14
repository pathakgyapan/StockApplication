package com.tcs.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STOCK")
public class StockModel {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column(name="Stock_Id")
	public String stockId;
	
	@Column(name="Product_Id")
	public String productId;
	
	@Column(name="Quantity")
	public long quantity;
	
	@Column(name="Location")
	public String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "StockModel [id=" + id + ", stockId=" + stockId + ", productId=" + productId + ", quantity=" + quantity
				+ ", location=" + location + "]";
	}
	
	
	
	
	

}
