package com.xworkz.mobile.service;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobilesServiceImpl implements MobileService {

	private MobileDAO dao = new MobileDAOImpl();

	@Override
	public int validateAndSave(MobileEntity entity) {
		boolean validateBrand = false;
		boolean validatePrice = false;
		boolean validateIsAndroid;
		if (entity != null) {
			System.out.println("entity is not null,can validate data");
			String brand = entity.getBrand();
			if (brand != null && !brand.isEmpty() && brand.length() > 3 && brand.length() < 8) {
				System.out.println("brand is valid");
				validateBrand = true;
			} else {
				System.out.println("brand is invalid");
				validateBrand = false;
			}
			double price = entity.getPrice();
			if (price > 5000 && price < 20000) {
				System.out.println("price is valid");
				validatePrice = true;
			} else {
				System.out.println("price is invalid");
				validatePrice = false;
			}
			Boolean isAndroid = entity.isAndroid();
			if (isAndroid != null) {
				System.out.println("isAndroid is valid");
				validateIsAndroid = true;
			} else {
				System.out.println("isAndroid is invalid");
				validateIsAndroid = false;
			}
			if (validateBrand && validatePrice && validateIsAndroid) {
				System.out.println("running successfully,success");
				dao.save(entity);
				return 1;
			}
		} else {
			System.out.println("entity is null");
		}
		return 0;
	}

	@Override
	public void validateAndReadAll() {
		dao.readAll();
	}

	@Override
	public double validateAndreadPriceByBrand(String brand) {

		return dao.readPriceByBrand(brand);
	}

	@Override
	public double validateAndfindMaxPrice() {

		return dao.findMaxPrice();
	}

	@Override
	public double validateAndfindMinPrice() {

		return dao.findMinPrice();
	}

	@Override
	public double validateAndfindTotalPrice() {

		return dao.findTotalPrice();
	}

	@Override
	public void validateAndUpdateBrandByPrice(String brand, double price) {
		dao.updateBrandByPrice(brand, price);

	}

	@Override
	public void validateAndDeleteById(int id) {
		dao.deleteById(id);

	}
}
