package com.xworkz.customer.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.customer.entity.CustomerEntity;
import com.xworkz.customer.util.SFUtil;

public class CustomerDAOImpl implements CustomerDAO {

	SessionFactory factory = SFUtil.getFactory();
	Transaction trans = null;

	@Override
	public int save(CustomerEntity entity) {
		int id = 0;
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			id = (int) session.save(entity);
			System.out.println(id);
			session.flush();
			session.clear();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public CustomerEntity readById(int id) {

		try (Session session = factory.openSession()) {

			CustomerEntity entity = session.get(CustomerEntity.class, id);
			return entity;

		}
	}


	@Override
	public void saveList(List<CustomerEntity> entity) {
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			AtomicInteger atomicInteger = new AtomicInteger(0);
			entity.forEach(d -> {
				CustomerEntity en = session.load(CustomerEntity.class, d.getId());
				if (en != null) {
					session.save(d);
					System.out.println(d);
				}
				if (atomicInteger.incrementAndGet() % 10 == 0) {
					session.flush();
				}
			});
			trans.commit();
		}
	}

	@Override
	public void deleteList(List<Integer> ids) {
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			AtomicInteger atomicInteger = new AtomicInteger(0);
			ids.forEach((d) -> {
				CustomerEntity entity = session.get(CustomerEntity.class, d);
				if (entity != null) {
					session.delete(entity);
				}
				if (atomicInteger.incrementAndGet() % 10 == 0) {
					session.flush();
				}
			});
			trans.commit();
		}
	}

	@Override
	public CustomerEntity loadById(int id) {
		try (Session session = factory.openSession()) {

			CustomerEntity entity = session.load(CustomerEntity.class, id);
			return entity;

		}
	}
}
