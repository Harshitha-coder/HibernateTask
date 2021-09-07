package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileDAO {

	int save(MobileEntity entity);

	void readAll();

	double readPriceByBrand();

	double findMaxPrice();

	double findMinPrice();

	double findTotalPrice();

	void updateBrandByPrice();

	void deleteById();
}
