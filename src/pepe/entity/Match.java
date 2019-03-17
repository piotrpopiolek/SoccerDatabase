package pepe.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="match")
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMatch")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")	
	private Date date;
	
	@Column(name="hour")
	private String hour;
	
	@Column(name="referee")	
	private String referee;
	
	@Column(name="bet1")	
	private double bet1;
	
	@Column(name="betX")
	private double betX;
	
	@Column(name="bet2")
	private double bet2;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="team_idHomeTeam")
	private Team homeTeam;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="team_idAwayTeam")
	private Team awayTeam;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="season_idSeason")
	private Season season;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="league_idLeague")
	private League league;
	
	public Match() {
		
	}
	
	public Match(Date date, String hour, String referee, double bet1, double betX, double bet2) {
		this.date = date;
		this.hour = hour;
		this.referee = referee;
		this.bet1 = bet1;
		this.betX = betX;
		this.bet2 = bet2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public double getBet1() {
		return bet1;
	}

	public void setBet1(double bet1) {
		this.bet1 = bet1;
	}

	public double getBetX() {
		return betX;
	}

	public void setBetX(double betX) {
		this.betX = betX;
	}

	public double getBet2() {
		return bet2;
	}

	public void setBet2(double bet2) {
		this.bet2 = bet2;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", date=" + date + ", hour=" + hour + ", referee=" + referee + ", bet1=" + bet1
				+ ", betX=" + betX + ", bet2=" + bet2 + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
				+ ", season=" + season + ", league=" + league + "]";
	}
	
}
