package com.hano.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
			person.setPerson_id(5);
			person.setPerson_name("Ronny");
			person.setPerson_email("sunny@amazon.com");
			person.setContact("734734374");
			session.save(person);
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
