package com.example.runningApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Run {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long runId;
	
	private double distance;
	private int timeInMinutes;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	

	public Run() {
		super();
	}
	
	public Run(double distance, int timeInMinutes, User user) {
		super();
		this.distance = distance;
		this.timeInMinutes = timeInMinutes;
		this.user = user;
	}

	public long getRunId() {
		return runId;
	}

	public void setRunId(long runId) {
		this.runId = runId;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTimeInMinutes() {
		return timeInMinutes;
	}

	public void setTimeInMinutes(int timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
