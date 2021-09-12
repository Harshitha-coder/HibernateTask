package com.xworkz.mobile;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.service.MobileService;
import com.xworkz.mobile.service.MobilesServiceImpl;

public class MobileTester {

	public static void main(String[] args) {

		MobileEntity entity = new MobileEntity("Oppo", 9000, true);

		MobileService service = new MobilesServiceImpl();
		// service.validateAndSave(entity);
		service.validateAndReadAll();
		System.out.println("****************");
		double price = service.validateAndreadPriceByBrand("Oppo");
		System.out.println("mobile price is:" + price);

		System.out.println("****************");
		double maxPrice = service.validateAndfindMaxPrice();
		System.out.println("mobile maxPrice is:" + maxPrice);

		System.out.println("****************");
		double minPrice = service.validateAndfindMinPrice();
		System.out.println("mobile minPrice is:" + minPrice);

		System.out.println("****************");
		double totalPrice = service.validateAndfindTotalPrice();
		System.out.println("mobile totalPrice is:" + totalPrice);

		System.out.println("****************");
		service.validateAndUpdateBrandByPrice("Samsung", 9000);

		System.out.println("****************");
		service.validateAndDeleteById(6);
	}
}
