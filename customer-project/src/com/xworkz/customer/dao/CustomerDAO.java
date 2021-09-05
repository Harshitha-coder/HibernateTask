package com.xworkz.customer.dao;

import java.util.List;

import com.xworkz.customer.entity.CustomerEntity;

public interface CustomerDAO {

	int save(CustomerEntity entity);

	CustomerEntity readById(int id);
	
	void saveList(List<CustomerEntity> entity);
	
	void deleteList(List<Integer> ids);
	
	CustomerEntity loadById(int id);
}
