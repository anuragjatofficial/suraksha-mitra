package com.masai.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.CriminalNotFoundException;
import com.masai.exceptions.InvalidInputSelectionException;

public class CriminalServicesImpl implements CriminalServices {

	@Override
	public String addNewCriminal(int id, List<Integer> crimes, Map<Integer, Criminal> criminals, Scanner sc)throws InvalidInputSelectionException, IOException{
		System.out.println("Enter criminal name : ");
		String name = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter Date of Birth(in yyyy-mm-dd format");
		String pDOB = sc.next();
		LocalDate dob = LocalDate.parse(pDOB);
		System.out.println("Enter gender(m/f)");
		String gender = sc.next();
		System.out.println("Enter Identifying mark : ");
		String idMark = sc.nextLine();
		System.out.println("Enter first arrasted date : ");
		String fArrDate = sc.next();
		LocalDate fDate = LocalDate.parse(fArrDate);
		System.out.println("Choose Police staion area :"+"\n"+"Press 1 : for Mumbai"+"\n"+"Press 2 : for Thane"+"\n"+"Press 3 : for Pune"+"\n"+"Press 4 : for Nagpur");
		int choice = sc.nextInt();
		String psa = "";
		switch(choice) {
		case 1:
			psa += "Mumbai";
			break;
		case 2: 
			psa += "Thane";
			break;
		case 3:
			psa += "Pune";
			break;
		case 4:
			psa += "Nagpur";
			break;
			default:
				throw new InvalidInputSelectionException("Invalid input");
		}
		Criminal criminal = new Criminal(id,name,dob,gender,idMark,fDate,psa,crimes);
		criminals.put(id, criminal);
		/*
		 * int criminal_id, 
		 * String name, LocalDate dob, 
		 * String gender
		 * String identifying_mark \n
		 * LocalDate first_arrest_date 
		 * String arrested_from_ps_area,
		 * List<Integer> crimeIds
		 * 
		 */
		return "criminal added succesfully : )";
	}

	@Override
	public String updateCriminalDetails(int id, Criminal criminal, Map<Integer, Criminal> criminals)
			throws CriminalNotFoundException {
		if (criminals != null && criminals.size() > 0) {
			if (criminals.containsKey(id)) {
				criminals.put(id, criminal);
				return "criminal data updated Succesfully : )";
			} else {
				throw new CriminalNotFoundException("It seems like there is no any existing criminal with this id : |");
			}
		} else {
			throw new CriminalNotFoundException("wooh ! Criminal list is empty : )");
		}
	}

}
