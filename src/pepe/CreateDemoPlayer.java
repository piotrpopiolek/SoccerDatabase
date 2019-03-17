package pepe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pepe.entity.City;
import pepe.entity.Country;
import pepe.entity.Match;
import pepe.entity.Nationality;
import pepe.entity.Player;
import pepe.entity.Position;
import pepe.entity.Team;

public class CreateDemoPlayer {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Match.class)
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(City.class)
				.addAnnotatedClass(Team.class)
				.addAnnotatedClass(Nationality.class)
				.addAnnotatedClass(Position.class)
				.addAnnotatedClass(Player.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			
			Date datePlayer1 = new Date();
			
			try {
				datePlayer1 = dateformat.parse("17/07/1990");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Player player1 = new Player("Robert", "Lewandowski", datePlayer1);
			
			System.out.println(player1.toString());
			
			//start a transaction
			session.beginTransaction();
			
			int theId = 13;
			City monachium = session.get(City.class, theId);
			
			int theIdN = 1;
			Nationality polish = session.get(Nationality.class, theIdN);
			
			int theIdP = 5;
			Position position = session.get(Position.class, theIdP);
			
			int theIdT = 10;
			Team team = session.get(Team.class, theIdT);
			
			player1.setCity(monachium);
			player1.setNationality(polish);
			player1.setPosition(position);
			player1.setTeam(team);
			
			session.save(player1);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
