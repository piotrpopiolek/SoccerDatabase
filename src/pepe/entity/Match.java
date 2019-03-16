package pepe.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="match")
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMatch")
	private int id;
	
	@Column(name="team_idHomeTeam")
	private int idHomeTeam;
	
	@Column(name="team_idAwayTeam")
	private int idAwayTeam;
	
	@Column(name="season_idSeason")	
	private int idSeason;
	
	@Column(name="league_idLeague")	
	private int idLeague;
	
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
	
	public Match() {
		
	}

	public Match(int idHomeTeam, int idAwayTeam, int idSeason, int idLeague, Date date, String hour, String referee,
			double bet1, double betX, double bet2) {
		this.idHomeTeam = idHomeTeam;
		this.idAwayTeam = idAwayTeam;
		this.idSeason = idSeason;
		this.idLeague = idLeague;
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

	public int getIdHomeTeam() {
		return idHomeTeam;
	}

	public void setIdHomeTeam(int idHomeTeam) {
		this.idHomeTeam = idHomeTeam;
	}

	public int getIdAwayTeam() {
		return idAwayTeam;
	}

	public void setIdAwayTeam(int idAwayTeam) {
		this.idAwayTeam = idAwayTeam;
	}

	public int getIdSeason() {
		return idSeason;
	}

	public void setIdSeason(int idSeason) {
		this.idSeason = idSeason;
	}

	public int getIdLeague() {
		return idLeague;
	}

	public void setIdLeague(int idLeague) {
		this.idLeague = idLeague;
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
		return "Match [id=" + id + ", idHomeTeam=" + idHomeTeam + ", idAwayTeam=" + idAwayTeam + ", idSeason="
				+ idSeason + ", idLeague=" + idLeague + ", date=" + date + ", hour=" + hour + ", referee=" + referee
				+ ", bet1=" + bet1 + ", betX=" + betX + ", bet2=" + bet2 + "]";
	}
	
}
