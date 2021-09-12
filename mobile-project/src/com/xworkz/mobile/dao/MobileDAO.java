package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileDAO {

	int save(MobileEntity entity);

	void readAll();

	double readPriceByBrand(String brand);

	double findMaxPrice();

	double findMinPrice();

	double findTotalPrice();

	void updateBrandByPrice(String brand, double price);

	void deleteById(int id);
}
