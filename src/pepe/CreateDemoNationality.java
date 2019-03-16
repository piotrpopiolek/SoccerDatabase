package pepe;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pepe.entity.City;
import pepe.entity.Country;
import pepe.entity.Match;
import pepe.entity.Nationality;
import pepe.entity.Team;

public class CreateDemoNationality {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Match.class)
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(City.class)
				.addAnnotatedClass(Team.class)
				.addAnnotatedClass(Nationality.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Nationality nationality = new Nationality("polish");
			
			//start a transaction
			session.beginTransaction();
			
			session.save(nationality);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
