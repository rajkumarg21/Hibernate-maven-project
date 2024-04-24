package com.raj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateXmlDemo {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    Session session = factory.openSession();  
    Transaction t = session.beginTransaction();  
    Customer e1=new Customer();    
    e1.setId(3);    
    e1.setName("chandra");    
    e1.setCity("univers");    
 
session.save(e1);  
t.commit();  
System.out.println("successfully saved");    
factory.close();  
session.close();     
	}

}
