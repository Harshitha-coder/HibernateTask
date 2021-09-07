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
			int id = (int) session.save(entity);
			trans.commit();
			return id;
		}
	}

	@Override
	public void readAll() {
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("from MobileEntity");
			List list = query.list();
			System.out.println(list);
		}
	}

	@Override
	public double readPriceByBrand() {
		double price = 0;
		try (Session session = factory.openSession()) {
			Query query = session
					.createQuery("select mobile.price from MobileEntity as mobile where mobile.brand ='Vivo'");
			Object object = query.uniqueResult();
			if (object != null) {
				price = (double) object;
			}
		}
		return price;
	}

	@Override
	public double findMaxPrice() {
		double price = 0;
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("select max(price) from MobileEntity");
			Object object = query.uniqueResult();
			if (object != null) {
				price = (double) object;
			}
		}
		return price;
	}

	@Override
	public double findMinPrice() {
		double price = 0;
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("select min(price) from MobileEntity ");
			Object object = query.uniqueResult();
			if (object != null) {
				price = (double) object;
			}
		}
		return price;
	}

	@Override
	public double findTotalPrice() {
		double price = 0;
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("select sum(price) from MobileEntity ");
			Object object = query.uniqueResult();
			if (object != null) {
				price = (double) object;
			}
		}
		return price;
	}

	@Override
	public void updateBrandByPrice() {

		try (Session session = factory.openSession()) {
			Transaction trans = session.beginTransaction();
			Query query = session
					.createQuery("update MobileEntity as mobile set mobile.brand='Redmi' where mobile.price='13000'");
			int value = query.executeUpdate();
			System.out.println(value);
			trans.commit();
		}

	}

	@Override
	public void deleteById() {
		try (Session session = factory.openSession()) {
			Transaction trans = session.beginTransaction();
			Query query = session.createQuery("delete from MobileEntity mobile where mobile.id='1'");
			int value = query.executeUpdate();
			System.out.println(value);
			trans.commit();
		}

	}
}
