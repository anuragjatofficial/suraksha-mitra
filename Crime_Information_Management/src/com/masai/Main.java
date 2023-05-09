package com.masai;

import com.masai.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.utility.*;
import com.masai.service.*;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;
import com.masai.exceptions.InvalidInputSelectionException;
import com.masai.exceptions.InvalidLoginCrediantials;

public class Main {
	private static boolean adminLogin(Scanner sc) {
		System.out.println("Enter username ");
		String username = sc.next();
		System.out.println("Enter your password");
		String password = sc.next();
		if (username.equals(Admin.username) && password.equals(Admin.password)) {
			System.out.println("Welocome Admin How can I help you ?");
			return true;

		} else {
			return false;
		}

	}

	public static void adminServices(Scanner sc, Map<Integer, Crime> crimes, Map<Integer, Criminal> criminals)
			throws InvalidLoginCrediantials, CrimeNotFoundException, IOException {
		CrimeservicesImpl d1 = new CrimeservicesImpl();
		CriminalServicesImpl d2 = new CriminalServicesImpl();
		try {
			if (!adminLogin(sc)) {
				throw new InvalidLoginCrediantials("Invalid Credentials");
			} else {
				System.out.println("Logged in succesfully : )");
			}
			boolean flag = true;
			while (flag) {
				System.out.println("1. Add a new crime");
				System.out.print("");
				System.out.println("2. Update crime details");
				System.out.print("");
				System.out.println("3. Add a new criminal");
				System.out.print("");
				System.out.println("4. Update criminal details");
				System.out.print("");
				System.out.println("5. Assign criminals to crime");
				System.out.print("");
				System.out.println("6. Remove criminals from crime");
				System.out.print("");
				System.out.println("7. Delete Crime using crimeId");
				System.out.print("");
				System.out.println("8. Logout");
				System.out.print("");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					addNewCrime(crimes, sc, d1);
					break;
				case 2:
					updateCrime(crimes, sc, d1);
					break;
				case 3:
					addNewCriminal(criminals, sc, d2);
					break;
				case 4:
					updateCriminalDetais(criminals, sc, d2);
					break;
				case 5:
					assignCriminalsToCrime(crimes, criminals, sc); // last working line
					break;
				case 6:
					unassignCriminalsFromCrime(crimes, criminals, sc);
					break;
				case 7:
					deleteCrimeById(crimes, sc);
					break;
				case 8:
					deleteCriminalById(criminals, sc);
				case 9:
					flag = false;
					break;
				default:
					throw new InvalidInputSelectionException("Invalid selection " + num);
				}
			}
		} catch (InvalidInputSelectionException e) {
			System.out.println(e.getMessage());
		} catch (InvalidLoginCrediantials e) {
			System.out.println(e.getMessage());
		}

	}

	private static void deleteCriminalById(Map<Integer, Criminal> criminals, Scanner sc) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter the criminal id which you want to delete : ");
			int id = sc.nextInt();
			if (!criminals.containsKey(id)) {
				throw new CriminalNotFoundException("No criminal found for this id : (");
			}
			criminals.remove(id);
			System.out.println("crime deleted succesfully");
		} catch (CriminalNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void deleteCrimeById(Map<Integer, Crime> crimes, Scanner sc) {
		try {
			System.out.println("Enter the crime id which you want to delete : ");
			int id = sc.nextInt();
			if (!crimes.containsKey(id)) {
				throw new CrimeNotFoundException("No crime found for this id : (");
			}
			crimes.remove(id);
			System.out.println("crime deleted succesfully");
		} catch (CrimeNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void unassignCriminalsFromCrime(Map<Integer, Crime> crimes, Map<Integer, Criminal> criminals,
			Scanner sc) {
		try {
			System.out.println("Enter the crime id from which you need to remove criminal : ");
			int crId = sc.nextInt();
			if (!crimes.containsKey(crId)) {
				throw new CrimeNotFoundException("No crime found for this id ");
			}
			if (crimes.get(crId).getCriminalId().size() != 0) {
				System.out.println("Enter the criminal id which you want to remove from this crime : ");
				int t = sc.nextInt();
				if (crimes.get(crId).getCriminalId().contains(t)) {
					crimes.get(crId).getCriminalId().remove(crimes.get(crId).getCriminalId().indexOf(t));
					System.out.println("criminal removed from this crime : )");
				} else {
					System.out.println("This criminal is not assigned to this crime so far : (");
				}
			} else {
				System.out.println("No criminal have been assigned for this crime...");
			}
		} catch (CrimeNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addNewCriminal(Map<Integer, Criminal> criminals, Scanner sc, CriminalServicesImpl d2)
			throws InvalidInputSelectionException, IOException {
		int id = IdGeneration.idGenerator();
		List<Integer> crimes = new ArrayList<>();
		String out = d2.addNewCriminal(id, crimes, criminals, sc);
		System.out.println(out);

	}

	private static void updateCrime(Map<Integer, Crime> crimes, Scanner sc, CrimeservicesImpl d1)
			throws CrimeNotFoundException, InvalidInputSelectionException {
		// TODO Auto-generated method stub
		System.out.println("Enter the crime id which you want to Updated :");
		int id = sc.nextInt();
		if (!crimes.containsKey(id)) {
			throw new CrimeNotFoundException("No crime found for this id : (");
		}
		System.out.println("Enter Updated crime type :");
		String crimeType = sc.next();
		sc.nextLine();
		System.out.println("Enter Updated description :");
		String description = sc.nextLine();
		System.out.println("Choose Updated Police staion area :" + "\n" + "1. Mumbai" + "\n" + "2. Thane" + "\n"
				+ "3. Pune" + "\n" + "4. Nagpur");
		int choice = sc.nextInt();
		String psa = "";
		switch (choice) {
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
			psa += "Naagpur";
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
		List<Integer> criminals = new ArrayList<>();
		Crime crime = new Crime(id, crimeType, description, psa, crimeDate, victim, criminals);
		d1.updateCrimeDetails(id, crime, crimes);
	}

	private static void assignCriminalsToCrime(Map<Integer, Crime> crimes, Map<Integer, Criminal> criminals,
			Scanner sc) {
		try {
			System.out.println("Enter the crime id to which you want to assign criminals");
			int id = sc.nextInt();
			if (!crimes.containsKey(id)) {
				throw new CrimeNotFoundException("No crime found for this id : (");
			}
			System.out.println();
			sc.nextLine();
			System.out.println("Enter criminal ids you want assign to this crime");
			String[] scrs = sc.nextLine().trim().split(",");
			List<Integer> crs = new ArrayList<>();
			for (int i = 0; i < scrs.length; i++) {
				crs.add(Integer.parseInt(scrs[i]));
			}
			Crime cr = crimes.get(id);
			cr.setCriminalId(crs);
			System.out.println("criminals assigned to crime : )");
		} catch (CrimeNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void updateCriminalDetais(Map<Integer, Criminal> criminals, Scanner sc, CriminalServicesImpl d2)
			throws InvalidInputSelectionException {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter the criminal id whose details has to be Updated :");
			int id = sc.nextInt();
			if (!criminals.containsKey(id)) {
				throw new CriminalNotFoundException("No criminal found for this id : (");
			}
			sc.nextLine();
			System.out.println("Enter updated criminal name : ");
			String name = sc.nextLine();

			System.out.println("Enter updated Date of Birth(in yyyy-mm-dd format");
			String pDOB = sc.next();
			LocalDate dob = LocalDate.parse(pDOB);
			System.out.println("Enter updated gender(m/f)");
			String gender = sc.next();
			sc.nextLine();
			System.out.println("Enter updated Identifying mark : ");
			String idMark = sc.nextLine();
			System.out.println("Enter updated first arrasted date : ");
			String fArrDate = sc.next();
			LocalDate fDate = LocalDate.parse(fArrDate);
			System.out.println("Choose Updated Police staion area :" + "\n" + "Press 1 : for Mumbai" + "\n"
					+ "Press 2 : for Thane" + "\n" + "Press 3 : for Pune" + "\n" + "Press 4 : for Nagpur");
			int choice = sc.nextInt();
			String psa = "";
			switch (choice) {
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
			List<Integer> crimes = new ArrayList<>();
			Criminal criminal = new Criminal(id, name, dob, gender, idMark, fDate, psa, crimes);
			String out = d2.updateCriminalDetails(id, criminal, criminals);
			System.out.println(out);
		} catch (CriminalNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addNewCrime(Map<Integer, Crime> crimes, Scanner sc, CrimeservicesImpl d1)
			throws InvalidInputSelectionException {
		try {
			int id = IdGeneration.idGenerator();
			List<Integer> criminals = new ArrayList<>();
			String output = d1.addNewCrime(id, criminals, crimes, sc);
			/*
			 * System.out.println("Enter crime type :"); String crimeType = sc.next();
			 * sc.nextLine(); System.out.println("Enter description :"); String description
			 * = sc.nextLine();
			 * System.out.println("Choose Police staion area :"+"\n"+"1. Mumbai"
			 * +"\n"+"2. Thane"+"\n"+"3. Pune"+"\n"+"5. Nagpur"); int choice = sc.nextInt();
			 * String psa = ""; switch(choice) { case 1: psa += "Mumbai"; break; case 2: psa
			 * += "Thane"; break; case 3: psa += "Pune"; break; case 4: psa += "Naagpur";
			 * break; default: throw new InvalidInputSelectionException("Invalid input"); }
			 * System.out.println("Enter Date (in YYYY-MM-DD format :"); String date =
			 * sc.next(); LocalDate crimeDate = LocalDate.parse(date); sc.nextLine();
			 * System.out.println("Enter victim's name"); String victim = sc.nextLine();
			 * Crime crime = new
			 * Crime(id,crimeType,description,psa,crimeDate,victim,criminals);
			 * crimes.put(id, crime);
			 */
			System.out.println(crimes);
			System.out.println(output);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Map<Integer, Crime> crimes = FileExists.crimeflie();
		Map<Integer, Criminal> criminals = FileExists.criminalflie();
		Scanner sc = new Scanner(System.in);
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("Welcome to crime Management System .. !");
				System.out.println("Choose one of them");
				System.out.println("1. Admin Login");
				System.out.println("2. Public services");
				System.out.println("3. Exit app");
				int n = sc.nextInt();
				switch (n) {
				case 1:
					adminServices(sc, crimes, criminals);
					break;
				case 2:
					publicServices(sc, crimes, criminals);
					break;
				case 3:
					flag = false;
					break;
				default:
					throw new InvalidInputSelectionException("Invalid Input");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("crime.ser"));
				ObjectOutputStream croos = new ObjectOutputStream(new FileOutputStream("criminal.ser"));
				croos.writeObject(criminals);
				coos.writeObject(crimes);
				croos.close();
				coos.close();
				System.out.println(criminals);
				System.out.println(crimes);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private static void publicServices(Scanner sc, Map<Integer, Crime> crimes, Map<Integer, Criminal> criminals) {
		try {
			boolean flag = true;
			while(flag) {
				System.out.println("welcome to public service section :)");
				System.out.println("");
				System.out.println("Press 1 : view all crimes");
				System.out.println("Press 2 : view all crimes in your area");
				System.out.println("Press 3 : search criminal by name");
				System.out.println("Press 4 : search crime by description");
				System.out.println("Press 5 : go back to main sectoin");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println(viewAllCrimes(crimes));
					break;
				case 2:
//					System.out.println("");
					System.out.println(viewAllCrimesByArea(crimes, sc));
					break;
				case 3:
					System.out.println(searchCriminalByName(criminals,sc));
					break;
				case 4:
					System.out.println(searchCrimeDecsription(crimes,sc));
					break;
				case 5:
					flag = false;
					break;
				default:
					throw new InvalidInputSelectionException("Invalid input :(");

				}
			}
		} catch (InvalidInputSelectionException e) {
			System.out.println(e.getMessage());
		}
	}

	private static String searchCrimeDecsription(Map<Integer, Crime> crimes, Scanner sc) {
//		paused here 
		System.out.println("Search crime description: ");
		sc.nextLine();
		String name = sc.nextLine();
		String bag = "No results found for " + name;
		for(Map.Entry<Integer,Crime> entry : crimes.entrySet()){
			Crime c = entry.getValue();
			if(c.getDecscription().equals(name)) {
				bag = "";
				bag += c+"\n";
			}
		}
		return bag;
	}
	
	private static String searchCriminalByName(Map<Integer, Criminal> criminals, Scanner sc) {
//		paused here 
		System.out.println("Search criminal name : ");
		sc.nextLine();
		String name = sc.nextLine();
		String bag = "No results found for " + name;
		for(Map.Entry<Integer,Criminal> entry : criminals.entrySet()){
			Criminal c = entry.getValue();
			if(c.getName().equals(name)) {
				bag = "";
				bag += c+"\n";
			}
		}
		return bag;
	}

	private static String viewAllCrimes(Map<Integer, Crime> crimes) {
		String bag = "";
		for (Map.Entry<Integer, Crime> entry : crimes.entrySet()) {
			Crime c = entry.getValue();
			bag += c + "\n";
		}
		return bag;
	}

	private static String viewAllCrimesByArea(Map<Integer, Crime> crimes, Scanner sc) {

		System.out.println("Choose Updated Police staion area :" + "\n" + "Press 1 : for Mumbai" + "\n"
				+ "Press 2 : for Thane" + "\n" + "Press 3 : for Pune" + "\n" + "Press 4 : for Nagpur");
		int choice = sc.nextInt();
		String psa = "";
		try {
			switch (choice) {
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
		} catch (InvalidInputSelectionException e) {
			System.out.println(e.getMessage());
		}
		String bag = "";
		for (Map.Entry<Integer, Crime> entry : crimes.entrySet()) {
			Crime c = entry.getValue();
			if (psa.equals(c.getPs_area())) {
				bag += c + "\n";
			}
		}
		return bag;
	}
}
