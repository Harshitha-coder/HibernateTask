package com.xworkz.mobile.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.util.SFUtil;

public class MobileDAOImpl implements MobileDAO {

	private SessionFactory factory = SFUtil.getFactory();

	@Override
	public int save(MobileEntity entity) {
		try (Session session = factory.openSession()) {
			Transaction trans = session.beginTransaction();
	        int id=(int)session.save(entity);
			trans.commit();
			return id;			
		}
	}

	@Override
	public void read() {
		try (Session session = factory.openSession()) {
		Query query=session.createQuery("from MobileEntity");
			List list=query.list();
			System.out.println(list);
		}
	}
}
