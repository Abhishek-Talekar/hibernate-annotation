package com.hano.registry;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hano.entities.Person;

public class SessionFactoryServiceRegistry {
	public static SessionFactory sessionFactory;
	public static Map<String, String> settings = null;
	static {
		settings = new HashMap<>();
		settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/common");
		settings.put("hibernate.connection.username", "root");
		settings.put("hibernate.connection.password", "root123");
		settings.put("hibernate.show_sql", "true");
		settings.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		settings.put("hibernate.hbm2ddl.auto", "update");
		MetadataSources metadataSources = new MetadataSources(
				new StandardServiceRegistryBuilder().applySettings(settings).build());
		metadataSources.addAnnotatedClass(Person.class);
		sessionFactory = metadataSources.buildMetadata().buildSessionFactory();

//		try {
//
//			
//			sessionFactory = (SessionFactory) new MetadataSources(
//					new StandardServiceRegistryBuilder().applySettings(settings).build())
//							.addAnnotatedClass(Person.class).buildMetadata().buildSessionFactory();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
