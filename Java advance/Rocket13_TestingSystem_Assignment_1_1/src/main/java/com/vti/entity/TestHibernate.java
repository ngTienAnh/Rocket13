package com.vti.entity;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import com.vti.entity.TestingCategory;

public class TestHibernate {
	public static void main(String[] args) {
		Session session = null;
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();
// Insert dữ liệu:
			TestingCategory testingcategory = new TestingCategory();
			testingcategory.setName("Category Test");
			session.save(testingcategory);
			System.out.println("Crearte Success!!!");
// Select dữ liệu cơ bản:
			Query<TestingCategory> query = session.createQuery("FROM TestingCategory");
			List<TestingCategory> listResul = query.list();
			for (TestingCategory testingCategory2 : listResul) {
				System.out.println(testingCategory2.getId() + " " + testingCategory2.getName());
			}
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(TestingCategory.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}
}