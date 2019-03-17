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

public class CreateDemoTeamLeagueSeason {

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
				.addAnnotatedClass(Season.class)
				.addAnnotatedClass(League.class)
				.addAnnotatedClass(TeamLeagueSeason.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			int theId = 10;
			Team team = session.get(Team.class, theId);
			
			int theIdN = 1;
			Season season = session.get(Season.class, theIdN);
			
			int theIdP = 2;
			League league = session.get(League.class, theIdP);
			
			TeamLeagueSeason teamLeagueSeason = new TeamLeagueSeason(team, season, league);
			
			teamLeagueSeason.setTeam(team);
			teamLeagueSeason.setSeason(season);
			teamLeagueSeason.setLeague(league);	
			
			session.save(teamLeagueSeason);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
