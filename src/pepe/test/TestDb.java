package pepe.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pepe.entity.Match;

public class TestDb {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Match.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Date data = new Date();
			Match tempMatch = new Match(1, 2, 1, 1, null, "12:00", "Gil P", 1.66, 3.60, 5.25);
			
			System.out.println(tempMatch.toString());
			
			//start a transaction
			session.beginTransaction();
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
