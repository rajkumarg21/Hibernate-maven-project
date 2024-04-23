package com.raj;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name ="customer_order",schema = "core")
public class Order {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orederId;
	
	@Column(name="order_name")
	private String orderName;
	
	@Column(name="Order_date")
	@Temporal(TemporalType.DATE)
	private Date OrderDate;
	
	@Lob
	private byte[] orderImage;
	
	@Column(name="is_present")
	private boolean isPresent;

	public Order() {
		super();

	}

	public Order(int orederId, String orderName, Date orderDate, byte[] orderImage, boolean isPresent) {
		super();
		this.orederId = orederId;
		this.orderName = orderName;
		OrderDate = orderDate;
		this.orderImage = orderImage;
		this.isPresent = isPresent;
	}

	public int getOrederId() {
		return orederId;
	}

	public void setOrederId(int orederId) {
		this.orederId = orederId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public byte[] getOrderImage() {
		return orderImage;
	}

	public void setOrderImage(byte[] orderImage) {
		this.orderImage = orderImage;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	@Override
	public String toString() {
		return "Order [orederId=" + orederId + ", orderName=" + orderName + ", OrderDate=" + OrderDate + ", orderImage="
				+ Arrays.toString(orderImage) + ", isPresent=" + isPresent + "]";
	}

}
