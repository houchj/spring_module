package com.test.hibernate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DynamicEntityTest {

	public static void main(String[] args) throws Exception {
		System.out.println("testssssss");

		DynamicEntityTest.setUp();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Event("Our very first event!", new Date()));
		session.save(new Event("A follow up event", new Date()));
		session.getTransaction().commit();
		session.close();

		Session s = sessionFactory.openSession();
		s.beginTransaction();
		// Create a customer entity
		Map<String, Object> david = new HashMap<>();
		david.put("name", "David");
		david.put("id", 1l);
		// Create an organization entity
//		Map<String, String> foobar = new HashMap<>();
//		foobar.put("name", "Foobar Inc.");
		// Save both
		s.save("com.test.hibernate.Customer", david);
//		s.save("Organization", foobar);
		session.getTransaction().commit();
		s.close();

	}

	private static org.hibernate.SessionFactory sessionFactory;

	protected static void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures
																									// settings
																									// from
																									// hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
			throw e;
		}
	}

}
