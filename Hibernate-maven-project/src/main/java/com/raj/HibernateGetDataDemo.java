package com.raj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateGetDataDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Customer customer = session.get(Customer.class, 0);
		System.out.println(customer);

		Order order = session.load(Order.class, 1);
		System.out.println(order);

	}

}
