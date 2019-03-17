package pepe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pepe.entity.City;
import pepe.entity.Country;
import pepe.entity.League;
import pepe.entity.Match;
import pepe.entity.Nationality;
import pepe.entity.Player;
import pepe.entity.Position;
import pepe.entity.Season;
import pepe.entity.Team;
import pepe.entity.TeamLeagueSeason;

public class CreateDemoMatch {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(City.class)
				.addAnnotatedClass(Team.class)
				.addAnnotatedClass(Nationality.class)
				.addAnnotatedClass(Position.class)
				.addAnnotatedClass(Player.class)
				.addAnnotatedClass(Match.class)
				.addAnnotatedClass(Season.class)
				.addAnnotatedClass(League.class)
				.addAnnotatedClass(TeamLeagueSeason.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			
			Date date = new Date();
			
			try {
				date = dateformat.parse("17/07/2019");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//start a transaction
			session.beginTransaction();
			
			/*
			 * int theId = 1; Match matchtest = session.get(Match.class, theId);
			 */
			
			//System.out.println(matchtest.toString());
			
			
			  int theIdH = 10; Team homeTeam = session.get(Team.class, theIdH);
			  
			  int theIdA = 11; Team awayTeam = session.get(Team.class, theIdA);
			  
			  Season season = new Season("2018/2019"); 
			  League league = new League("Liga Mistrzów");
			  
			  //session.save(season); //session.save(league);
			  
			  Match match = new Match(date, "20:00", "Marciniak", 1.2, 3.2, 2.0);
			  match.setAwayTeam(awayTeam); 
			  match.setHomeTeam(homeTeam);
			  match.setSeason(season); 
			  match.setLeague(league);
			  
			  session.save(match);
			  
			  System.out.println(match.toString());
			 
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
