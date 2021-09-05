package com.xworkz.customer;

import java.util.Arrays;

import com.xworkz.customer.dao.CustomerDAO;
import com.xworkz.customer.dao.CustomerDAOImpl;
import com.xworkz.customer.entity.CustomerEntity;

public class CustomerTester {

	public static void main(String[] args) {

		CustomerEntity entity = new CustomerEntity("Harshitha", "Chickballapur", 7899154768l, "harshitha@gmail.com");

		CustomerDAO dao = new CustomerDAOImpl();
		dao.save(entity);

		CustomerEntity value = dao.readById(21);
		System.out.println(value);

		((CustomerDAO) dao).deleteList(Arrays.asList(5, 6, 7, 8));
		
		//dao.loadById(221);
	}

}
