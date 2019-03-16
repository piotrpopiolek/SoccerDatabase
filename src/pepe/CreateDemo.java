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

public class CreateDemo {

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
			
			Country poland = new Country("Poland");
			
			City poznan = new City("Poznañ");
			City warszawa = new City("Bia³ystok");
			City gdansk = new City("Gdañsk");
			
			System.out.println(poznan.toString());
			
			//Date data = new Date();
			//Match tempMatch = new Match(1, 2, 1, 1, null, "12:00", "Gil P", 1.66, 3.60, 5.25);
			
			//System.out.println(tempMatch.toString());
			
			//start a transaction
			session.beginTransaction();
			
			/*
			 * System.out.println("\nSaving the Match : " + tempMatch);
			 * session.save(tempMatch); System.out.println("Saved the Match: " + tempMatch);
			 */
			
			//session.save(poland);
			
			int theId = 15;
			Country tempMatchRead = session.get(Country.class, theId);
			
			//System.out.println("Read the Cities : " + tCountry.getCities());
			tempMatchRead.addCity(poznan);
			tempMatchRead.addCity(warszawa);
			//System.out.println("Read the Cities : " + tCountry.getCities());
			tempMatchRead.addCity(gdansk);

			session.save(tempMatchRead);
			session.save(warszawa);
			session.save(poznan);
			session.save(gdansk);
			//System.out.println("Read the Cities : " + tCountry.getCities());
			
			//System.out.println("\nSaving the Country : " + tCountry);
			//System.out.println("Saved the Country: " + tCountry);
			
			//int theId = 1;
			//Match tempMatchRead = session.get(Match.class, theId);
			//System.out.println("Read the Match : " + tempMatchRead);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
