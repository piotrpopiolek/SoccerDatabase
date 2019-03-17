package pepe.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="team_league_season")
public class TeamLeagueSeason {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTeam_league_season")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="team_idTeam")
	private Team team;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="season_idSeason")
	private Season season;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="league_idleague")
	private League league;
	
	public TeamLeagueSeason() {
		
	}

	public TeamLeagueSeason(Team team, Season season, League league) {
		this.team = team;
		this.season = season;
		this.league = league;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
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
	
}
