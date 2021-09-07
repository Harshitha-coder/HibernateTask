package com.xworkz.mobile;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileTester {

	public static void main(String[] args) {

		MobileEntity entity = new MobileEntity("Vivo", 13000, true);

		MobileDAO dao = new MobileDAOImpl();
		dao.save(entity);
		dao.readAll();

		double value = dao.readPriceByBrand();
		System.out.println("mobile price is:" + value);

		double maxPrice = dao.findMaxPrice();
		System.out.println("max price is:" + maxPrice);

		double minPrice = dao.findMinPrice();
		System.out.println("min price is:" + minPrice);

		double totalPrice = dao.findTotalPrice();
		System.out.println("total price is:" + totalPrice);

		dao.updateBrandByPrice();

		dao.deleteById();

	}

}
