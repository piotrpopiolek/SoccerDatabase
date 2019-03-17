package pepe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="league")
public class League {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLeague")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="league", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Match> matches;
	
	public League() {
		
	}

	public League(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "League [id=" + id + ", name=" + name + "]";
	}
	
	public void addMatch(Match theMatch) {
		
		if (matches == null) {
			matches = new ArrayList<Match>();
		}
		
		matches.add(theMatch);
		theMatch.setLeague(this);
	}
}
