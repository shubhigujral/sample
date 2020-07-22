package com.amazonCustomer.RestDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Repository;

import com.amazonCustomer.model.AmazonCustomer;

@Repository
public class AmazonCustDAO {

	// @SuppressWarnings({ "unchecked", "rawtypes" })
	@SuppressWarnings("unchecked")
	public List<AmazonCustomer> findallcustomer() {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		List<AmazonCustomer> amazoncust = new ArrayList<AmazonCustomer>();
		String str = "From com.amazonCustomer.model.AmazonCustomer";
		System.out.println("aa stris" + str);
		amazoncust = session.createQuery(str).list();
		System.out.println("create query enter");

		/*
		 * java.util.Iterator itr = amazoncust.iterator(); while (itr.hasNext())
		 * { System.out.println(itr.next()); }
		 */
		for (AmazonCustomer amazonCustomer : amazoncust) {
			System.out.println(amazonCustomer.getId());
			System.out.println(amazonCustomer.getName());
			System.out.println(amazonCustomer.getEmail());
		}
		System.out.println("Successfully saved");
		t.commit();
		sessionfactory.close();
		session.close();
		return amazoncust;

	}

	public AmazonCustomer findbyid(int id) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		AmazonCustomer amazoncust = new AmazonCustomer();
		String hql = "From com.amazonCustomer.model.AmazonCustomer where id=?";
		org.hibernate.Query query = session.createQuery(hql);
		query.setParameter(0, id);
		amazoncust = (AmazonCustomer) ((org.hibernate.Query) query).uniqueResult();
		System.out.println(amazoncust.getName());
		System.out.println(amazoncust.getEmail());
		System.out.println("Successfully saved");
		t.commit();
		sessionfactory.close();
		session.close();
		return amazoncust;

	}
}
