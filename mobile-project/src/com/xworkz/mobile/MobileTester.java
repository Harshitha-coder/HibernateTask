package com.xworkz.mobile;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileTester {

	public static void main(String[] args) {

		MobileEntity entity = new MobileEntity("Vivo", 13000, true);

		MobileDAO dao = new MobileDAOImpl();
		dao.save(entity);
		dao.read();
		
	}

}
