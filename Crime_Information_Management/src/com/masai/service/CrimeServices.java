package com.masai.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.*;


public interface CrimeServices {
	public String addNewCrime(int id ,List<Integer> criminals,Map<Integer,Crime> crimes,Scanner sc)throws InvalidInputSelectionException, FileNotFoundException, IOException;
	public String updateCrimeDetails(int id, Crime crime, Map<Integer, Crime> crimes)throws CrimeNotFoundException;
	public String updateCriminalDetails(int id, Criminal criminal,Map<Integer,Criminal> criminals)throws CriminalNotFoundException;
	
}
/*
 * update crime details using crime_id, can update type, description, ps_area,
 * date and name of victim.
 * 
 * update criminal details like using criminal_id, can update name, dob, gender,
   identifying_mark, first_arrest_date, arrested_from_ps_area.
 */