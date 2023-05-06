package com.masai.entities;

import java.time.LocalDate;
import java.util.List;

public class Criminal {
	private int criminal_id;
	private LocalDate dob;
	private String gender;
	private String identifying_mark;
	private LocalDate first_arrest_date;
	private String arrested_from_ps_area;
	private List<Integer> crimeIds;

	public Criminal(int criminal_id, LocalDate dob, String gender, String identifying_mark, LocalDate first_arrest_date,
			String arrested_from_ps_area, List<Integer> crimeIds) {
		super();
		this.criminal_id = criminal_id;
		this.dob = dob;
		this.gender = gender;
		this.identifying_mark = identifying_mark;
		this.first_arrest_date = first_arrest_date;
		this.arrested_from_ps_area = arrested_from_ps_area;
		this.crimeIds = crimeIds;
	}

	public int getCriminalId() {
		return criminal_id;
	}

	public void setCriminalId(int criminal_id) {
		this.criminal_id = criminal_id;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentifying_mark() {
		return identifying_mark;
	}

	public void setIdentifying_mark(String identifying_mark) {
		this.identifying_mark = identifying_mark;
	}

	public LocalDate getFirst_arrest_date() {
		return first_arrest_date;
	}

	public void setFirst_arrest_date(LocalDate first_arrest_date) {
		this.first_arrest_date = first_arrest_date;
	}

	public String getArrested_from_ps_area() {
		return arrested_from_ps_area;
	}

	public void setArrested_from_ps_area(String arrested_from_ps_area) {
		this.arrested_from_ps_area = arrested_from_ps_area;
	}

	public int getCriminal_id() {
		return criminal_id;
	}

	public void setCriminal_id(int criminal_id) {
		this.criminal_id = criminal_id;
	}

	public List<Integer> getCrimeIds() {
		return crimeIds;
	}

	public void setCrimeIds(List<Integer> crimeIds) {
		this.crimeIds = crimeIds;
	}

	@Override
	public String toString() {
		return "Criminal [crimeId=" + criminal_id + ", dob=" + dob + ", gender=" + gender + ", identifying_mark="
				+ identifying_mark + ", first_arrest_date=" + first_arrest_date + ", arrested_from_ps_area="
				+ arrested_from_ps_area + "]";
	}

}