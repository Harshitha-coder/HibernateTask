package com.xworkz.mobile.service;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileService {

	int validateAndSave(MobileEntity entity);

	void validateAndReadAll();

	double validateAndreadPriceByBrand(String brand);

	double validateAndfindMaxPrice();

	double validateAndfindMinPrice();

	double validateAndfindTotalPrice();

	void validateAndUpdateBrandByPrice(String brand, double price);

	void validateAndDeleteById(int id);

}
