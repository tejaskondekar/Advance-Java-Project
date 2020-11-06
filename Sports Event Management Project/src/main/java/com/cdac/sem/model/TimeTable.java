package com.cdac.sem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "time_table", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class TimeTable {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "seq")
	private int id;
	
	@Column(name = "team1")
	private String team1;
	
	@Column(name = "team2")
	private String team2;
	
	@Column(name = "match_date")
	private String matchDate;
	
	@Column(name = "time")
	private String time;

	@Column(name = "venue")
	private String venue;
		
	@Column(name = "result")
	private String result;
	
	public TimeTable() {
		super();
	}
	
	public TimeTable(String team1, String team2, String matchDate, String time, String venue, String result) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.matchDate = matchDate;
		this.time = time;
		this.venue = venue;
		this.result = result;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
