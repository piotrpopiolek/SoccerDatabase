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
@Table(name="season")
public class Season {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSeason")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="season", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Match> matches;
	
	public Season() {
		
	}

	public Season(String name) {
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

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", name=" + name + "]";
	}
	
	public void addMatch(Match theMatch) {
		
		if (matches == null) {
			matches = new ArrayList<Match>();
		}
		
		matches.add(theMatch);
		theMatch.setSeason(this);
	}
	
}
