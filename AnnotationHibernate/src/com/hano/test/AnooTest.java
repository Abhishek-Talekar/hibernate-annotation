package com.hano.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionFactoryRegistry;

import com.hano.entities.Person;
import com.hano.registry.SessionFactoryServiceRegistry;

public class AnooTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Person person = new Person();
		Transaction transaction = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryServiceRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			person.setPerson_id(3);
			person.setPerson_name("Abhi");
			person.setPerson_email("talek@amazon.com");
			person.setContact("98128912");
			
			flag = true;
		} finally {
			if (session != null) {
			}
			if (flag == true) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
			SessionFactoryServiceRegistry.closeSessionFactory();
		}
	}

}
