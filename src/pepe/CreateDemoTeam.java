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

public class CreateDemoTeam {

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
			
			Team tTeam = new Team("Lech Poznañ", "Bu³garska", "Adam Nawa³ka");
			Team tTeam2 = new Team("Lech Poznañ II", "Bu³garska", "Trener 1");
			Team legia = new Team("Legia Warszawa", "Stadion", "Sa Pinto");
			
			System.out.println(tTeam.toString());
			
			
			//start a transaction
			session.beginTransaction();
			
			int theId = 11;
			City tempCityRead = session.get(City.class, theId);
			
			System.out.println(tempCityRead.toString());
			
			tempCityRead.addTeam(tTeam);
			tempCityRead.addTeam(tTeam2);
			
			session.save(tempCityRead);
			session.save(tTeam);
			session.save(tTeam2);
			
			System.out.println("Read the Team : " + tempCityRead.getTeams());
			
			int theIdLegia = 5;
			City tempCityReadLegia = session.get(City.class, theIdLegia);
			
			System.out.println(tempCityRead.toString());
			
			tempCityReadLegia.addTeam(legia);
			
			session.save(tempCityReadLegia);
			session.save(legia);
			
			System.out.println("Read the Team : " + tempCityRead.getTeams());
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
