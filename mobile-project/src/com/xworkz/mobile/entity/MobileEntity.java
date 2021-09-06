package com.xworkz.mobile.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mobile_table")
public class MobileEntity implements Serializable {

	@Column(name="M_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="M_BRAND")
	private String brand;
	@Column(name="M_PRICE")
	private double price;
	@Column(name="M_ISANDROID")
	private boolean isAndroid;
	
	public MobileEntity() {
		
	}

	public MobileEntity(String brand, double price, boolean isAndroid) {
		super();
		this.brand = brand;
		this.price = price;
		this.isAndroid = isAndroid;
	}

	@Override
	public String toString() {
		return "MobileEntity [id=" + id + ", brand=" + brand + ", price=" + price + ", isAndroid=" + isAndroid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MobileEntity other = (MobileEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAndroid() {
		return isAndroid;
	}

	public void setAndroid(boolean isAndroid) {
		this.isAndroid = isAndroid;
	}
}
