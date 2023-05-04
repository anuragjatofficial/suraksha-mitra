package com.masai.entities;

import java.time.LocalDate;

public class Crime {
	private int crimeId;
	private String crimeType;
	private String decscription;
	private String ps_area;
	private LocalDate date;
	private String victim;

	
	
	public Crime(int crimeId, String crimeType, String decscription, String ps_area, LocalDate date, String victim) {
		this.crimeId = crimeId;
		this.crimeType = crimeType;
		this.decscription = decscription;
		this.ps_area = ps_area;
		this.date = date;
		this.victim = victim;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public String getDecscription() {
		return decscription;
	}

	public void setDecscription(String decscription) {
		this.decscription = decscription;
	}

	public String getPs_area() {
		return ps_area;
	}

	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", crimeType=" + crimeType + ", decscription=" + decscription
				+ ", ps_area=" + ps_area + ", date=" + date + ", victim=" + victim + "]";
	}
	
}
