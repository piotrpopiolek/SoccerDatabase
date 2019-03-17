package pepe.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="player")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPlayer")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="nationality_idNationality")
	private Nationality nationality;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="position_idPosition")
	private Position position;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_idCity")
	private City city;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="team_idTeam")
	private Team team;
	
	public Player() {
		
	}

	public Player(String firstName, String lastName, Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", nationality=" + nationality + ", position=" + position + ", city=" + city + ", team="
				+ team + "]";
	}
	
}
