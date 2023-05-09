package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import com.masai.Main;
public class Crime implements Serializable{
	private int crimeId;
	private String crimeType;
	private String decscription;
	private String ps_area;
	private LocalDate date;
	private String victim;
	private List<Integer> criminalIds;
	

	public Crime(int crimeId, String crimeType, String decscription, String ps_area, LocalDate date, String victim,
			List<Integer> criminalIds) {
		super();
		this.crimeId = crimeId;
		this.crimeType = crimeType;
		this.decscription = decscription;
		this.ps_area = ps_area;
		this.date = date;
		this.victim = victim;
		this.criminalIds = criminalIds;
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

	public List<Integer> getCriminalId() {
		return criminalIds;
	}

	public void setCriminalId(List<Integer> criminalId) {
		this.criminalIds = criminalId;
	}

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", crimeType=" + crimeType + ", decscription=" + decscription
				+ ", ps_area=" + ps_area + ", date=" + date + ", victim=" + victim + "]"+"\n---------------------------------------------------------------------------------------------------------------";
	}
	
}
