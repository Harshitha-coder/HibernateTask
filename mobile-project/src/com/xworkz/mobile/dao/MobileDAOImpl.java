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
			Query query = session.getNamedQuery("readAll");
			List list = query.list();
			System.out.println(list);
		}
	}

	@Override
	public double readPriceByBrand(String brand) {
		double price = 0;
		try (Session session = factory.openSession()) {
			Query query = session
					.getNamedQuery("readPriceByBrand");
			query.setParameter("Brand", brand);
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
			Query query = session.getNamedQuery("findMaxPrice");
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
			Query query = session.getNamedQuery("findMinPrice");
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
			Query query = session.getNamedQuery("findTotalPrice");
			Object object = query.uniqueResult();
			if (object != null) {
				price = (double) object;
			}
		}
		return price;
	}

	@Override
	public void updateBrandByPrice(String brand,double price) {

		try (Session session = factory.openSession()) {
			Transaction trans = session.beginTransaction();
			Query query = session
					.getNamedQuery("updateBrandByPrice");
			query.setParameter("Brand", brand);
			query.setParameter("Price", price);
			int value = query.executeUpdate();
			System.out.println(value);
			trans.commit();
		}

	}

	@Override
	public void deleteById(int id) {
		try (Session session = factory.openSession()) {
			Transaction trans = session.beginTransaction();
			Query query = session.getNamedQuery("deleteById");
			query.setParameter("Id",id);
			int value = query.executeUpdate();
			System.out.println(value);
			trans.commit();
		}

	}
}
