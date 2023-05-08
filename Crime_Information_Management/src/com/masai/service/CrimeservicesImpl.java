package com.masai.service;

import java.time.LocalDate;
import java.util.*;
import java.io.*;
import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;
import com.masai.exceptions.InvalidInputSelectionException;
import com.masai.utility.FileExists;

public class CrimeservicesImpl implements CrimeServices ,Serializable{

	@Override
	public String updateCrimeDetails(int id, Crime crime, Map<Integer, Crime> crimes) throws CrimeNotFoundException {
		if (crimes != null && crimes.size() > 0) {
			if (crimes.containsKey(id)) {
				crimes.put(id, crime);
				return "crime updated succesfully : )";
			} else {
				throw new CrimeNotFoundException("No crime found for this Id :(");
			}
		} else {
			throw new CrimeNotFoundException("Crime List is empty :(");
		}
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

	@Override
	public String addNewCrime(int id, List<Integer> criminals, Map<Integer, Crime> crimes, Scanner sc) throws InvalidInputSelectionException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter crime type :");
		String crimeType = sc.next();
		sc.nextLine();
		System.out.println("Enter description :");
		String description = sc.nextLine();
		System.out.println("Choose Police staion area :"+"\n"+"1. Mumbai"+"\n"+"2. Thane"+"\n"+"3. Pune"+"\n"+"4. Nagpur");
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
		System.out.println("Enter Date (in YYYY-MM-DD format :");
		String date = sc.next();
		LocalDate crimeDate = LocalDate.parse(date);
		sc.nextLine();
		System.out.println("Enter victim's name");
		String victim = sc.nextLine();
		Crime crime = new Crime(id,crimeType,description,psa,crimeDate,victim,criminals);
		crimes.put(id, crime);
		return "product added succesfully..!";
	}

}