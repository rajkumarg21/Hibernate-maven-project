package com.raj;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class HqlDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// get data from Customer Entity
		String quary = "from Customer";
		Query q = session.createQuery(quary);
		List<Customer> list = q.getResultList();
		for (Customer customer : list) {
			System.out.println(customer.getName() + " is from " + customer.getCity());
		}

		// get data from Order Entity
		String quary1 = "from Order where orderName= 'pipasa'";
		Query q1 = session.createQuery(quary1);
		List<Order> list1 = q1.getResultList();
		for (Order order : list1) {
			System.out.println(order.getOrderName() + " is from " + order.getOrderDate());
		}

		// query to update
		Query q2 = session.createQuery("update Customer set city =:c where name=:n");
		q2.setParameter("c", "bhopal");
		q2.setParameter("n", "gagan");
		int r = q2.executeUpdate();
		System.out.println(r + " line updated");
		tx.commit();
	}

}
