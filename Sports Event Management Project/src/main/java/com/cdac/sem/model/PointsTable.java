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
@Table(name =  "points_table", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class PointsTable {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "seq")
	private int id;
	
	@Column(name = "team_name")
	private String teamName;
	
	@Column(name = "matches")
	private int matches;
	
	@Column(name = "win")
	private int win;
	
	@Column(name = "lose")
	private int lose;
	
	@Column(name = "tie_draw")
	private int tieDraw;
	
	@Column(name = "points")
	private int points;
	
	public PointsTable() {
		super();
	}

	public PointsTable(int id, String teamName, int matches, int win, int lose, int tieDraw, int points) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.matches = matches;
		this.win = win;
		this.lose = lose;
		this.tieDraw = tieDraw;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getTieDraw() {
		return tieDraw;
	}

	public void setTieDraw(int tieDraw) {
		this.tieDraw = tieDraw;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
