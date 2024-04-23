package com.raj;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Name: Rajkumar Saad
 * Date: 23/04/2024
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		// factory.getCurrentSession()
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("gagan");
		customer.setCity("delhi");

		Order order = new Order();
		order.setOrderName("pipasa");
		order.setOrderDate(new Date());
		order.setPresent(true);

		// to add image
		/*
		 * FileInputStream fis = new FileInputStream("src/main/java/pic.png "); byte[]
		 * data =new byte[fis.available()]; fis.read(data); order.setOrderImage(data);
		 */

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		session.save(order);
		tx.commit();

		session.close();
	}
}
