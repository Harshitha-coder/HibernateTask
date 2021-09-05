package com.xworkz.customer;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.customer.dao.CustomerDAO;
import com.xworkz.customer.dao.CustomerDAOImpl;
import com.xworkz.customer.entity.CustomerEntity;

public class SaveListTester {

	public static void main(String[] args) {

		List<CustomerEntity> customerentities = new ArrayList<CustomerEntity>();
		for (int i = 0; i < 100; i++) {
			CustomerEntity entity1 = new CustomerEntity("Ranjitha", "Banglore", 8073965342l, "ranjitha@gmail.com");

			customerentities.add(entity1);
		}
		System.out.println(customerentities.size());

		CustomerDAO dao = new CustomerDAOImpl();
		dao.saveList(customerentities);
	}

}
