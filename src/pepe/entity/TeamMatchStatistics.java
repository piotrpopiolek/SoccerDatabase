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
@Table(name="team_match_statistics")
public class TeamMatchStatistics {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTeam_match_statistics")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="team_idTeam")
	private Team team;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="statistics_idStatistics")
	private Statistics statistics;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="match_idMatch")
	private Match match;
	
	public TeamMatchStatistics() {
		
	}

	public TeamMatchStatistics(Team team, Statistics statistics, Match match) {
		this.team = team;
		this.statistics = statistics;
		this.match = match;
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

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "TeamMatchStatistics [id=" + id + ", team=" + team + ", statistics=" + statistics + ", match=" + match
				+ "]";
	}
	
}
