package com.sports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sportsinfo")
public class Sports {
	private String name;
	@Column(name = "playercount")
	private int playerCount;
	@Column(name = "coachname")
	private String coachName;

	@Id
	@Column(name = "sportsid")
	@GeneratedValue(generator = "sports_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sports_seq", sequenceName = "sports_sequence", initialValue = 100, allocationSize = 1)
	private Integer sportsId;

	@Enumerated(EnumType.STRING)
	private Type type;
	private String duration;
	private String sponsors;
	private String stadium;
	private String city;

	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sports(String name, int playerCount, String coachName, Type type, String duration, String sponsors,
			String stadium, String city) {
		super();
		this.name = name;
		this.playerCount = playerCount;
		this.coachName = coachName;
		this.type = type;
		this.duration = duration;
		this.sponsors = sponsors;
		this.stadium = stadium;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public Integer getSportsId() {
		return sportsId;
	}

	public void setSportsId(Integer sportsId) {
		this.sportsId = sportsId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSponsors() {
		return sponsors;
	}

	public void setSponsors(String sponsors) {
		this.sponsors = sponsors;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Sports [name=" + name + ", playerCount=" + playerCount + ", coachName=" + coachName + ", sportsId="
				+ sportsId + ", type=" + type + ", duration=" + duration + ", sponsors=" + sponsors + ", stadium="
				+ stadium + ", city=" + city + "]";
	}

}
