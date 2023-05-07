package com.masai;

import com.masai.*;
import java.io.*;
import java.util.*;
import com.masai.entities.Crime;
import com.masai.utility.*;
import com.masai.service.*;
import com.masai.exceptions.InvalidInputSelectionException;
import com.masai.exceptions.InvalidLoginCrediantials;

public class Main {
	static CrimeservicesImpl d1 = new CrimeservicesImpl();

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

	public static void adminServices(Scanner sc, Map<Integer, Crime> crimes) throws InvalidLoginCrediantials {

		try {
			if (!adminLogin(sc)) {
				throw new InvalidLoginCrediantials("Invalid Credentials");
			}
			System.out.println("1. Add a new crime");
			System.out.print("");
			System.out.println("2. Update crime ");
			System.out.print("");
			System.out.println("3. Update criminal details");
			System.out.print("");
			System.out.println("4. Assign criminal to a crime");
			System.out.print("");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				addNewCrime(crimes, sc);
				break;
			case 2:
				updateCrime();
				break;
			case 3:
				updateCriminalDetais();
				break;
			case 4:
				assignCriminalToCrime();
				break;
			default:
				throw new InvalidInputSelectionException("Invalid selection " + num);
			}
		} catch (InvalidInputSelectionException e) {
			System.out.println(e.getMessage());
		} catch (InvalidLoginCrediantials e) {
			System.out.println(e.getMessage());
		}

	}

	private static void updateCrime() {
		// TODO Auto-generated method stub

	}

	private static void assignCriminalToCrime() {
		// TODO Auto-generated method stub

	}

	private static void updateCriminalDetais() {
		// TODO Auto-generated method stub

	}

	private static void addNewCrime(Map<Integer, Crime> crimes, Scanner sc) throws InvalidInputSelectionException {
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

	public static void main(String[] args) throws InvalidInputSelectionException, InvalidLoginCrediantials {
		Map<Integer, Crime> crimes = FileExists.crimeflie();
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
					adminServices(sc, crimes);
					break;
				case 2:
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
		}finally {
			try {
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("crime.ser"));
				coos.writeObject(crimes);	
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
