package com.masai.service;

import java.time.LocalDate;
import java.util.*;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;

public class CrimeservicesImpl implements CrimeServices {

	@Override
	public String updateCrimeDetails(int id, Crime crime, Map<Integer, Crime> crimes) throws CrimeNotFoundException {
		if (crimes != null && crimes.size() > 0) {
			if (crimes.containsKey(id)) {
				crimes.put(id, crime);
				return "crime updated succesfully : )";
			} else {
				throw new CrimeNotFoundException("No crime found for this Id :(");
			}
		}else {
			throw new CrimeNotFoundException("Crime List is empty :(");
		}
	}
	
	@Override
	public String updateCriminalDetails(int id, Criminal criminal,Map<Integer,Criminal> criminals)throws CriminalNotFoundException{
		if(criminals!=null&&criminals.size()>0) {
			if(criminals.containsKey(id)) {
				criminals.put(id, criminal);
				return "criminal data updated Succesfully : )";
			}else {
				throw new CriminalNotFoundException("It seems like there is no any existing criminal with this id : |");
			}
		}
		else {
			throw new CriminalNotFoundException("wooh ! Criminal list is empty : )");
		}
	}

}