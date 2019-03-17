package pepe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="statistics")
public class Statistics {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idStatistics")
	private int id;
	
	@Column(name="ballPossession")
	private int ballPossession;
	
	@Column(name="goalAttempts")
	private int goalAttempts;
	
	@Column(name="shotsOnGoal")
	private int shotsOnGoal;
	
	@Column(name="shotsOffGoal")
	private int shotsOffGoal;
	
	@Column(name="blockedShots")
	private int blockedShots;
	
	@Column(name="freeKicks")
	private int freeKicks;
	
	@Column(name="cornerKicks")
	private int cornerKicks;
	
	@Column(name="offsides")
	private int offsides;
	
	@Column(name="goalkeeperSaves")
	private int goalkeeperSaves;
	
	@Column(name="fouls")
	private int fouls;
	
	@Column(name="redCards")
	private int redCards;
	
	@Column(name="yellowCards")
	private int yellowCards;
	
	@Column(name="totalPasses")
	private int totalPasses;
	
	@Column(name="completedPasses")
	private int completedPasses;
	
	@Column(name="tackles")
	private int tackles;

	public Statistics() {
		
	}

	public Statistics(int ballPossession, int goalAttempts, int shotsOnGoal, int shotsOffGoal, int blockedShots,
			int freeKicks, int cornerKicks, int offsides, int goalkeeperSaves, int fouls, int redCards, int yellowCards,
			int totalPasses, int completedPasses, int tackles) {
		this.ballPossession = ballPossession;
		this.goalAttempts = goalAttempts;
		this.shotsOnGoal = shotsOnGoal;
		this.shotsOffGoal = shotsOffGoal;
		this.blockedShots = blockedShots;
		this.freeKicks = freeKicks;
		this.cornerKicks = cornerKicks;
		this.offsides = offsides;
		this.goalkeeperSaves = goalkeeperSaves;
		this.fouls = fouls;
		this.redCards = redCards;
		this.yellowCards = yellowCards;
		this.totalPasses = totalPasses;
		this.completedPasses = completedPasses;
		this.tackles = tackles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBallPossession() {
		return ballPossession;
	}

	public void setBallPossession(int ballPossession) {
		this.ballPossession = ballPossession;
	}

	public int getGoalAttempts() {
		return goalAttempts;
	}

	public void setGoalAttempts(int goalAttempts) {
		this.goalAttempts = goalAttempts;
	}

	public int getShotsOnGoal() {
		return shotsOnGoal;
	}

	public void setShotsOnGoal(int shotsOnGoal) {
		this.shotsOnGoal = shotsOnGoal;
	}

	public int getShotsOffGoal() {
		return shotsOffGoal;
	}

	public void setShotsOffGoal(int shotsOffGoal) {
		this.shotsOffGoal = shotsOffGoal;
	}

	public int getBlockedShots() {
		return blockedShots;
	}

	public void setBlockedShots(int blockedShots) {
		this.blockedShots = blockedShots;
	}

	public int getFreeKicks() {
		return freeKicks;
	}

	public void setFreeKicks(int freeKicks) {
		this.freeKicks = freeKicks;
	}

	public int getCornerKicks() {
		return cornerKicks;
	}

	public void setCornerKicks(int cornerKicks) {
		this.cornerKicks = cornerKicks;
	}

	public int getOffsides() {
		return offsides;
	}

	public void setOffsides(int offsides) {
		this.offsides = offsides;
	}

	public int getGoalkeeperSaves() {
		return goalkeeperSaves;
	}

	public void setGoalkeeperSaves(int goalkeeperSaves) {
		this.goalkeeperSaves = goalkeeperSaves;
	}

	public int getFouls() {
		return fouls;
	}

	public void setFouls(int fouls) {
		this.fouls = fouls;
	}

	public int getRedCards() {
		return redCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}

	public int getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}

	public int getTotalPasses() {
		return totalPasses;
	}

	public void setTotalPasses(int totalPasses) {
		this.totalPasses = totalPasses;
	}

	public int getCompletedPasses() {
		return completedPasses;
	}

	public void setCompletedPasses(int completedPasses) {
		this.completedPasses = completedPasses;
	}

	public int getTackles() {
		return tackles;
	}

	public void setTackles(int tackles) {
		this.tackles = tackles;
	}

	@Override
	public String toString() {
		return "Statistics [id=" + id + ", ballPossession=" + ballPossession + ", goalAttempts=" + goalAttempts
				+ ", shotsOnGoal=" + shotsOnGoal + ", shotsOffGoal=" + shotsOffGoal + ", blockedShots=" + blockedShots
				+ ", freeKicks=" + freeKicks + ", cornerKicks=" + cornerKicks + ", offsides=" + offsides
				+ ", goalkeeperSaves=" + goalkeeperSaves + ", fouls=" + fouls + ", redCards=" + redCards
				+ ", yellowCards=" + yellowCards + ", totalPasses=" + totalPasses + ", completedPasses="
				+ completedPasses + ", tackles=" + tackles + "]";
	}
	
}
