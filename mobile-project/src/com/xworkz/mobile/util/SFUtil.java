package com.xworkz.mobile.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SFUtil {

	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		if (factory != null && factory.isClosed()) {
			throw new IllegalStateException();
		}
		return factory;
	}

	static {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
	}
}
