package pepe;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pepe.entity.City;
import pepe.entity.Country;
import pepe.entity.Match;
import pepe.entity.Nationality;
import pepe.entity.Position;
import pepe.entity.Team;

public class CreateDemoPosition {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Match.class)
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(City.class)
				.addAnnotatedClass(Team.class)
				.addAnnotatedClass(Nationality.class)
				.addAnnotatedClass(Position.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Position forward = new Position("Forward");
			Position midfielder = new Position("Midfielder");
			Position goalkeeper = new Position("Goalkeeper");
			
			//start a transaction
			session.beginTransaction();
			
			session.save(forward);
			session.save(midfielder);
			session.save(goalkeeper);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
